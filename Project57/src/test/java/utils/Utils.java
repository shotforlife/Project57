package utils;

import pages.mapping.MainPageMap;
import runner.Runner;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by mukhin on 10/7/2016.
 */
public class Utils {
    public static MainPageMap mainPageMap = new MainPageMap(Runner.driver);

    public static void switchToWindow(String titleText, WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();

        for (String winHandle : handles) {
            driver.switchTo().window(winHandle);
            if (mainPageMap.getTextOfElement(driver).contains(titleText)) {
                break;
            }
            driver.close();
        }
    }
}
