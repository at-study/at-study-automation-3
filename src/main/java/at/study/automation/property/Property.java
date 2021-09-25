package at.study.automation.property;

import java.io.FileInputStream;
import java.util.Properties;

import lombok.SneakyThrows;

public class Property {

    // TODO: Параметризовать системной переменной
    private static String propertiesName = "default.properties";
    private static Properties properties = new Properties();
    private static boolean isInitialized = false;

    @SneakyThrows
    private static void init() {
        properties.load(new FileInputStream("src/test/resources/" + propertiesName));
        isInitialized = true;
    }

    public static String getStringProperty(String key) {
        if (!isInitialized) {
            init();
        }
        return properties.getProperty(key);
    }

    public static Integer getIntegerProperty(String key) {
        return Integer.parseInt(getStringProperty(key));
    }

    public static Boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getStringProperty(key));
    }

}
