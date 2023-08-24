import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "spring")
public class YamlConfigLoader{

    @Value("${yml.folder.path}")
    private String ymlFolderPath;

    public Map<String, AlertConfig> readYamlFiles() {
        Map<String, AlertConfig> resultMap = new HashMap<>();
        File folder = new File(ymlFolderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] yamlFiles = folder.listFiles((dir, name) -> name.endsWith(".yml"));
            if (yamlFiles != null) {
                Yaml yaml = new Yaml();
                for (File yamlFile : yamlFiles) {
                    try (FileInputStream fis = new FileInputStream(yamlFile)) {
                        AlertConfig alertConfig = yaml.loadAs(fis, AlertConfig.class);
                        resultMap.put(data.getKey(), data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resultMap;
    }
}

//This is a test for the above code
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Map;

@SpringBootTest
@Slf4j
public class YamlConfigLoaderTest{

    @Autowired
    private YamlConfigLoader yamlConfigLoader;

    @Test
    public void testReadYamlFiles() {
        Map<String, AlertConfig> resultMap = yamlReaderService.readYamlFiles();
        log.info("Loaded YAML data: {}", resultMap);
        // TODO:Add assertions here to validate the loaded data
    }
}
