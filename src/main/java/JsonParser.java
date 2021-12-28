import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;
import domain.CommunalServices;
import domain.Works;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {
    public void parser() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        URL resource = Main.class.getClassLoader().getResource("communal_services.json");
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));

        String json = new String(bytes);

        CommunalServices communalServices = objectMapper.readValue(json, CommunalServices.class);

        System.out.println(communalServices.getDescription());

        for (Works works : communalServices.getWorks()) {
            System.out.println(works);
        }

    }
}
