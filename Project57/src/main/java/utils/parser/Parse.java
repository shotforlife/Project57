package utils.parser;

import java.util.*;
import org.apache.commons.configuration.XMLConfiguration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Parse {
    public static final String BROWSER;
    public static final String URL;

    static {
        HashMap<String, String> config = read();
        URL = config.get("url");
        BROWSER = config.get("browser");

    }

    private static HashMap<String, String> read() {
        XMLConfiguration config = null;
        HashMap<String, String> map = new HashMap<>();
        try {
            config = new XMLConfiguration("config.xml");

            map.put("url", config.getString("url"));
            map.put("browser", config.getString("browser"));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
