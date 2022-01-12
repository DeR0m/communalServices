import UI.StartProject;

import Exception.IncorrectValueException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class CommunalServicesApplication{

    public static void main(String[] args) throws IOException, URISyntaxException, SQLException, IncorrectValueException {
        StartProject startProject = new StartProject();

        startProject.startProgram();
    }
}


