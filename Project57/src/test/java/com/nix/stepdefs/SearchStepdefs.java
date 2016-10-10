package com.nix.stepdefs;

import com.nix.Parser.Parse;
import com.nix.pageMapping.MainPageMap;
import com.nix.pageMapping.SearchMap;
import com.nix.runner.Runner;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * Created by mukhin on 10/10/2016.
 */
public class SearchStepdefs {
    public static SearchMap searchMap;

    @Given("^Get '(\\d+)' start page$")
    public void getStartPage(int arg0) throws Throwable {
        if (!Runner.driver.getCurrentUrl().equals(Parse.URL))
            Runner.driver.get(Parse.URL);
        searchMap = new SearchMap(Runner.driver);
    }
    
    @When("^I enter the search \"([^\"]*)\"$")
    public void iEnterTheSearch(String keyword) throws Throwable {
        searchMap.pickOutSearchField();
        searchMap.sendKeys(keyword);
    }
    

    @And("^I click 'search' button$")
    public void iClickSearchButton() throws Throwable {
        searchMap.clickOnSearchButton();
    }

    @Then("^I see that page contains results with my \"([^\"]*)\"$")
    public void iSeeThatPageContainsResultsWithMy(String keyword) throws Throwable {
        Assert.assertTrue("!!!", searchMap.SearchResults.getText().toLowerCase().contains(keyword.toLowerCase()));

    }

    @Then("^I see that page contains a message \"([^\"]*)\"$")
    public void iSeeThatPageContainsAMessage(String message) throws Throwable {
        Assert.assertEquals("!!!", message, searchMap.NoResults.getText());
    }
}
