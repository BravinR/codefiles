import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp")
public class MyAppConfigProperties {
    // Define properties with default values
    private String property1 = "default-value-1";
    private int property2 = 100;
    // Add other properties as needed

    // Getters and setters (You can omit the setters for read-only properties)

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public int getProperty2() {
        return property2;
    }

    public void setProperty2(int property2) {
        this.property2 = property2;
    }
}

