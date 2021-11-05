package homework.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is created to have some global configurations across the pages.
 */
public class Configurations {
    private static Configurations single_instance = null;
    private static Properties defaultProps = new Properties();


    public Configurations() {
        try {
            FileInputStream in = new FileInputStream(new File(getClass().getClassLoader().getResource("configuration.properties").toURI()));
            defaultProps.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Configurations getInstance() {
        if (single_instance == null)
            single_instance = new Configurations();
        return single_instance;
    }

    public static String getProperty(String key) {
        return defaultProps.getProperty(key);
    }
}
