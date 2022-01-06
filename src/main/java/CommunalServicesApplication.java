import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommunalServicesApplication{


    public static void main(String[] args) throws IOException, URISyntaxException, SQLException {
//        JsonParser jsonParser = new JsonParser();
////        jsonParser.parser();
//        JDBConnect jdbConnect = new JDBConnect();
//        jdbConnect.Connect();
        StartProgram();
    }

    public static void StartProgram() throws SQLException, IOException, URISyntaxException {
        JDBConnect jdbConnect = new JDBConnect();
        Connection connection = jdbConnect.getConnection();
        jdbConnect.createTable();

        System.out.println("Если вы желаете просмотреть информацию о работе - введите 1\n" +
                "Если Вы желаете посмотреть кто является заказчиком - введите 2\n" +
                "Если Вы желаете посмотреть информацию о бригаде - введите 3\n");
        int n;
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

                break;
            }
            case 3:{

                break;
            }

        }
    }

}


