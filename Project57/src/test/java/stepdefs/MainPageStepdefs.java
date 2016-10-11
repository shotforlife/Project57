package stepdefs;

import utils.parser.Parse;
import pages.mapping.MainPageMap;
import runner.Runner;
import utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mukhin on 10/7/2016.
 */
public class MainPageStepdefs {
    private static MainPageMap mainPage;

    @Given("^I am on '57 shop' start page$")
    public void iAmOn57StartPage() throws Throwable {
        if (!Runner.driver.getCurrentUrl().equals(Parse.URL))
            Runner.driver.get(Parse.URL);
        mainPage = new MainPageMap(Runner.driver);
    }


    @When("^I click on \"([^\"]*)\" button to go to another page$")
    public void iClickOnButton(String buttonName) throws Throwable {
        mainPage.clickOnButton(buttonName);
    }


    @Then("^I see the correct \"([^\"]*)\" of the page$")
    public void iSeeTheCorrectOfThePage(String titleText) throws Throwable {
        Utils.switchToWindow(titleText, Runner.driver);
        assertTrue(mainPage.getTextOfElement(Runner.driver).contains(titleText));
    }
}
