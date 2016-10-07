package com.nix.runner;

import com.nix.Parser.Parse;
import com.nix.pageMapping.MainPageMap;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/stackoverflow", "json:target/cucumber.json"},
        features = "src/test/java/com/nix/features",
        glue = "com/nix/stepdefs",
        tags = "@Smoke")

public class Runner {
    public static WebDriver driver;

    @BeforeClass
    public static void browserBegin() {
            Parse.chooseDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void theEnd() {
        driver.quit();
    }
}
