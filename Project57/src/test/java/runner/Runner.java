package runner;

import utils.StartDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/stackoverflow", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "stepdefs",
        tags = "@Check_Sorting_Of_Processors")

public class Runner {
    public static WebDriver driver;

    @BeforeClass
    public static void browserBegin() {
        StartDriver.chooseDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void theEnd() {
        driver.quit();
    }
}
