import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "spring")
public class YamlLoader{

    private String ymlFolderPath;

    public void setYmlFolderPath(String ymlFolderPath) {
        this.ymlFolderPath = ymlFolderPath;
    }

    public Map<String, Data> readYamlFiles() {
        Map<String, Data> resultMap = new HashMap<>();
        Resource[] yamlResources = new PathMatchingResourcePatternResolver().getResources(ymlFolderPath + "*.yml");
        Yaml yaml = new Yaml();

        for (Resource resource : yamlResources) {
            try (InputStream inputStream = resource.getInputStream()) {
                Data data = yaml.loadAs(inputStream, Data.class);
                resultMap.put(data.getKey(), data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}

