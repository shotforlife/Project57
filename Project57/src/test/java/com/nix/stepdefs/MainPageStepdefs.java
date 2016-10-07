package com.nix.stepdefs;

import com.nix.Parser.Parse;
import com.nix.pageMapping.MainPageMap;
import com.nix.runner.Runner;
import com.nix.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mukhin on 10/7/2016.
 */
public class MainPageStepdefs {
    private static MainPageMap mainPage;
    private static String URL;
    private static String PAGE;

    @Given("^I am on '57' start page$")
    public void iAmOnNixSolutionsStartPage() throws Throwable {
        if (!Runner.driver.getCurrentUrl().equals(Parse.URL))
            Runner.driver.get(Parse.URL);
        mainPage = new MainPageMap(Runner.driver);
    }


    @When("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String buttonName) throws Throwable {
        mainPage.clickOnButton(buttonName);
    }

    @Then("^I see the correct \"([^\"]*)\" of the page$")
    public void iSeeTheCorrectOfThePage(String titleText) throws Throwable {
        Utils.switchToWindow(titleText, Runner.driver);
        assertEquals(titleText, Runner.driver.getCurrentUrl());
    }
}
