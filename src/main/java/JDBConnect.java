import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnect {

    public void Connect() throws SQLException {
        String user = "postgres";
        String password = "123";
        String url = "jdbc:postgresql://localhost/CommunalServices";

        try(Connection connection = DriverManager.getConnection(url, user, password)){
            System.out.println("We're connection");
        }
    }
}
