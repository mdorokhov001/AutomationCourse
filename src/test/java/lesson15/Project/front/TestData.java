package lesson15.Project.front;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
    private Properties properties = new Properties();

    public TestData(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
