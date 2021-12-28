import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class CommunalServicesApplication{


    public static void main(String[] args) throws IOException, URISyntaxException, SQLException {
        JsonParser jsonParser = new JsonParser();
//        jsonParser.parser();
        JDBConnect jdbConnect = new JDBConnect();
        jdbConnect.Connect();
    }

}
