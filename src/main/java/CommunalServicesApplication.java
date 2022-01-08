import domain.Members;
import domain.Reported;
import domain.Works;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Scanner;

public class CommunalServicesApplication{

    public static Statement statement;
    public static Connection connection;

    public static void main(String[] args) throws IOException, URISyntaxException, SQLException {
        StartProgram();
    }

    public static void StartProgram() throws SQLException, IOException, URISyntaxException {

        int n;

        JDBConnect jdbConnect = new JDBConnect();
        Connection connection = jdbConnect.getConnection();
        jdbConnect.createTable();

        System.out.println("Если вы желаете просмотреть информацию о работе - введите 1\n" +
                "Если Вы желаете посмотреть кто является заказчиком - введите 2\n" +
                "Если Вы желаете посмотреть информацию о бригаде - введите 3\n");

        Scanner in = new Scanner(System.in);
        System.out.println("Введите что вы желаете сделать: ");
        n = in.nextInt();

        switch (n){
            case 1:{
                ResultSet resultSet = JDBConnect.statement.executeQuery("select * from works");
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("works_id"));
                    System.out.println("type: " + resultSet.getString("type"));
                    System.out.println("size: " + resultSet.getString("size"));
                    System.out.println("prefercompletedate: " + resultSet.getString("prefercompletedate"));
                }
                break;
            }
            case 2:{
                ResultSet resultSet = JDBConnect.statement.executeQuery("select * from reported");
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("reported_id"));
                    System.out.println("name: " + resultSet.getString("name"));
                }
                break;
            }
            case 3:{
                ResultSet resultSet = JDBConnect.statement.executeQuery("select * from members");
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("members_id"));
                    System.out.println("members: " + resultSet.getString("name"));
                }
                break;
            }
            case 4:{
                createWorks();
                createReported();
                createMembers();
            }
        }
    }

    public static void createWorks() throws SQLException, IOException, URISyntaxException {

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

    public static void createReported() throws SQLException, IOException, URISyntaxException {

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

    public static void createMembers() throws SQLException, IOException, URISyntaxException {

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
}


