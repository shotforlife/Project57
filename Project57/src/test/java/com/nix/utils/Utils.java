package com.nix.utils;

import com.nix.runner.Runner;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by mukhin on 10/7/2016.
 */
public class Utils {
    public static void switchToWindow(String url, WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();

        for (String winHandle : handles) {
            driver.switchTo().window(winHandle);
            if(driver.getCurrentUrl().equals(url)) {
                break;
            }
            driver.close();
        }
    }
}
