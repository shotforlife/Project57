package stepdefs;

import utils.parser.Parse;
import pages.mapping.SearchMap;
import runner.Runner;
import cucumber.api.java.en.*;
import org.junit.*;

/**
 * Created by mukhin on 10/10/2016.
 */
public class SearchStepdefs {
    private static SearchMap searchMap;

    @Given("^Get '57 shop' start page$")
    public void getStartPage() throws Throwable {
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
        Assert.assertTrue("!!!", searchMap.getTextOfSearchResult().toLowerCase().contains(keyword.toLowerCase()));

    }

    @Then("^I see that page contains a message \"([^\"]*)\"$")
    public void iSeeThatPageContainsAMessage(String message) throws Throwable {
        Assert.assertEquals("!!!", message, searchMap.getTextOfNoResult());
    }
}
