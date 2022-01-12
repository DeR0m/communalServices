package Config;

import domain.Works;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

public class JDBConnect {

    public static Statement statement;

    public void createTable() throws SQLException, IOException, URISyntaxException {

        JsonParser jsonParser = new JsonParser();
        Connection connection = getConnection();

        if (null != connection) {
            statement = connection.createStatement();
            statement.executeUpdate("drop table works, reported, team, members");
            statement.executeUpdate("create table IF NOT EXISTS Works  (works_id SERIAL NOT NULL, " +
                    "type CHARACTER VARYING(30) NOT NULL, " +
                    "size CHARACTER VARYING(30) NOT NULL," +
                    "preferCompleteDate CHARACTER VARYING(30) NOT NULL," +
                    "CONSTRAINT works__pk PRIMARY KEY (works_id))");
            statement.executeUpdate("create table IF NOT EXISTS reported (reported_id SERIAL NOT NULL," +
                    "works_id INTEGER," +
                    "name CHARACTER VARYING(30)," +
                    "CONSTRAINT reported__pk PRIMARY KEY (reported_id)," +
                    "CONSTRAINT reported__to__works FOREIGN KEY (works_id) REFERENCES works (works_id) ON DELETE CASCADE)");
            statement.executeUpdate("create table IF NOT EXISTS Team (team_id SERIAL NOT NULL," +
                    "works_id INTEGER NOT NULL," +
                    "CONSTRAINT team__pk PRIMARY KEY (team_id)," +
                    "CONSTRAINT team__to__works FOREIGN KEY (works_id) REFERENCES works (works_id) ON DELETE CASCADE)");
            statement.executeUpdate("create table IF NOT EXISTS members (members_id SERIAL NOT NULL," +
                    "team_id INTEGER," +
                    "name CHARACTER VARYING," +
                    "CONSTRAINT members__pk PRIMARY KEY (members_id)," +
                    "CONSTRAINT members__to__team FOREIGN KEY (team_id) REFERENCES team (team_id) ON DELETE CASCADE)");

            System.out.println("Table create");

            PreparedStatement statement1 = connection.prepareStatement("insert into works (type, size, prefercompletedate)" +
                    "values((?), (?), (?))", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement reported = connection.prepareStatement("insert into reported (name)" +
                    "values((?))", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement reported2 = connection.prepareStatement("update reported" +
                    " set works_id = ?");
            PreparedStatement team = connection.prepareStatement("insert into team (works_id)" +
                    "values((?))", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement members = connection.prepareStatement("insert into members(name)" +
                    "values ((?))");

            for (Works data : jsonParser.parser().getWorks()) {
                statement1.setString(1, data.getType());
                statement1.setString(2, data.getSize());
                statement1.setString(3, data.getPreferCompleteDate());
                statement1.addBatch();
            }
            statement1.executeBatch();

            ResultSet key = statement1.getGeneratedKeys();

            for (Works data2 : jsonParser.parser().getWorks()) {

                reported.setString(1, data2.getReporter().getName());
                reported.addBatch();
            }
            reported.executeBatch();

            for(Works data3 : jsonParser.parser().getWorks()){
                members.setString(1, String.valueOf(data3.getTeam().getMembers()));
                members.addBatch();
                members.executeUpdate();
            }

            while (key.next()) {
                reported2.setInt(1, key.getInt(1));
                reported2.addBatch();
                reported2.executeBatch();
                team.setInt(1, key.getInt(1));
                team.addBatch();
                team.executeBatch();
            }
        }
    }

    public Connection getConnection() throws SQLException, IOException, URISyntaxException {

        String user = "postgres";
        String password = "123";
        String url = "jdbc:postgresql://localhost/CommunalServices";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

