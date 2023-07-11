/*
package Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String filePath) {
        properties = loadProperties(filePath);
    }

    private Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getEmail() {
        String email = properties.getProperty("email");
        return email;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        return password;
    }

    public String getPackageName() {
        String packageName = properties.getProperty("appPackageName");
        return packageName;
    }
}*/
