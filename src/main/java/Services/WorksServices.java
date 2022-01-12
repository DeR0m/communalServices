package Services;

import Config.JDBConnect;
import domain.Members;
import domain.Reported;
import domain.Works;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Scanner;

public class WorksServices {

    private static JDBConnect jdbConnect = new JDBConnect();
    private static Connection connection;

    static {
        try {
            connection = jdbConnect.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void createWorks() throws SQLException, IOException, URISyntaxException {

        JDBConnect jdbConnect = new JDBConnect();
        Connection connection = jdbConnect.getConnection();

        Works works = new Works();

        System.out.println("Введите:\n" +
                "Тип работы\n" +
                "Размер работы\n" +
                "Желаемую дату выполнения работы\n");
        Scanner in = new Scanner(System.in);

        PreparedStatement statement1 = connection.prepareStatement("insert into works (type, size, prefercompletedate)" +
                "values((?), (?), (?))", Statement.RETURN_GENERATED_KEYS);

        System.out.println("Введите вашу задачу");

        statement1.setString(1, works.setType(in.next()));
        statement1.addBatch();
        statement1.setString(2, works.setSize(in.next()));
        statement1.addBatch();
        statement1.setString(3, works.setPreferCompleteDate(in.next()));
        statement1.addBatch();
        statement1.executeUpdate();

    }

    public void createReported() throws SQLException, IOException, URISyntaxException {

        JDBConnect jdbConnect = new JDBConnect();
        Connection connection = jdbConnect.getConnection();

        Reported reportedName = new Reported();

        Scanner in = new Scanner(System.in);

        PreparedStatement reported = connection.prepareStatement("insert into reported (name)" +
                "values((?))", Statement.RETURN_GENERATED_KEYS);

        System.out.println("Введите ваше имя");

        reported.setString(1, reportedName.setName(in.next()));
        reported.addBatch();
        reported.executeUpdate();

    }

    public void createMembers() throws SQLException, IOException, URISyntaxException {

        JDBConnect jdbConnect = new JDBConnect();
        Connection connection = jdbConnect.getConnection();

        Members membersName = new Members();

        Scanner in = new Scanner(System.in);

        PreparedStatement members = connection.prepareStatement("insert into members(name)" +
                "values ((?))");

        System.out.println("Введите имя работника");

        members.setString(1, membersName.setName(in.next()));
        members.addBatch();
        members.executeUpdate();

    }

    public void findById(int id) throws SQLException {

        String findById = "select * from works where works_id = 'id'";
        ResultSet resultSet = JDBConnect.statement.executeQuery(findById);
        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("works_id"));
            System.out.println("type: " + resultSet.getString("type"));
            System.out.println("size: " + resultSet.getString("size"));
            System.out.println("prefercompletedate: " + resultSet.getString("prefercompletedate"));
        }

    }

    public int deleteFromIdWork(int id) throws SQLException{

        int deleteId = 0;

        PreparedStatement deleteWorks = connection.prepareStatement("delete from works where works_id = ?");
        deleteWorks.setInt(1, id);
        deleteId = deleteWorks.executeUpdate();

        PreparedStatement deleteReported = connection.prepareStatement("delete from reported where reported_id = ?");
        deleteReported.setInt(1, id);
        deleteId = deleteReported.executeUpdate();

        PreparedStatement deleteMembers = connection.prepareStatement("delete from members where members_id = ?");
        deleteMembers.setInt(1, id);
        deleteId = deleteMembers.executeUpdate();

        return deleteId;

    }

    public int deleteFromIdMembers(int id) throws SQLException{

        int deleteId = 0;

        PreparedStatement deleteMembers = connection.prepareStatement("delete from members where members_id = ?");
        deleteMembers.setInt(1, id);
        deleteId = deleteMembers.executeUpdate();

        return deleteId;

    }


}
