import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFileService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Person> readJsonFilesFromFolder(String folderPath) throws IOException {
        List<Person> people = new ArrayList<>();
        
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null) {
            for (File file : files) {
                Person person = objectMapper.readValue(file, Person.class);
                people.add(person);
            }
        }

        return people;
    }
}

    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.0</version> <!-- Use the latest version -->
    </dependency>
