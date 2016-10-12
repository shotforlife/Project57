package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.mapping.SortingMap;
import runner.Runner;

/**
 * Created by lyzenkova on 10/10/2016.
 */
public class SortingStepdefs {

    private SortingMap sortingMap = new SortingMap(Runner.driver);
    private boolean expected = true;

    
    @And("^I click link 'processor AMD'$")
    public void iClickLinkProcessorAMD() throws Throwable {
        sortingMap.clickLinkProcessor();
    }
    
    @And("^I see page of goods 'processor AMD'$")
    public void iSeePageOfGoodsProcessorAMD() throws Throwable {
        Assert.assertTrue("Expected page of processor AMD didn't load", sortingMap.checkTitleProcessorAMD());
    }

    @And("^I click on the 'stock' link$")
    public void iClickOnTheStockLink() throws Throwable {
        sortingMap.clickStockLink();
    }

    @When("^I click on the 'descending' link$")
    public void iClickOnTheDescendingLink() throws Throwable {
        sortingMap.clickDescendingLink();
    }

    @Then("^I check that prices of products are in descending order$")
    public void iCheckThatPricesOfProductsAreInDescendingOrder() throws Throwable {
        Assert.assertTrue("!!!!!!!!!!!!!!!", sortingMap.checkingSort(sortingMap.writingPricesList()));
    }

    @When("^I click on the 'ascending' link$")
    public void iClickOnTheAscendingLink() throws Throwable {
        sortingMap.clickAscendingLink();
    }

    @Then("^I check that prices of products are in ascending order$")
    public void iCheckThatPricesOfProductsAreInAscendingOrder() throws Throwable {
        Assert.assertFalse("!!!!!!!!!!!!!", sortingMap.checkingSort(sortingMap.writingPricesList()));
    }
}
