package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Runner;
import utils.parser.Parse;

/**
 * Created by mukhin on 10/11/2016.
 */
public class StartDriver {
    public static void chooseDriver() {
        switch (Parse.BROWSER) {
            case "Firefox": {
                Runner.driver = new FirefoxDriver();
                break;
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                Runner.driver = new ChromeDriver();
                break;
            }

            default: {
                Runner.driver = new FirefoxDriver();
            }
        }
    }
}
