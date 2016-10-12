package stepdefs;

import utils.parser.Parse;
import pages.mapping.PurchaseMap;
import utils.regex.Regex;
import runner.Runner;
import cucumber.api.java.en.*;
import org.junit.Assert;

/**
 * Created by mukhin on 10/10/2016.
 */
public class PurchaseStepdefs {
    private static PurchaseMap purchaseMap;

    @Given("^I get the list of some products$")
    public void getTheListOfProducts() throws Throwable {
        if (!Runner.driver.getCurrentUrl().equals(Parse.URL))
            Runner.driver.get(Parse.URL);
        purchaseMap = new PurchaseMap(Runner.driver);
        purchaseMap.getProductList();
    }

    @When("^I click on Buy button \"([^\"]*)\" times on some products$")
    public void iClickOnBuyButtonTimesOnSomeProducts(int count) throws Throwable {
        purchaseMap.clickOnBuyButton(count);
    }

    @And("^I go in the basket$")
    public void iGoInTheBasket() throws Throwable {
        purchaseMap.getBasket();
    }

    @And("^I see that the basket have \"([^\"]*)\" product$")
    public void iSeeThatTheBasketHaveProduct(int count) throws Throwable {
        Assert.assertEquals("!!!", String.valueOf(count), purchaseMap.getProductsQuantityAttribute("value", count));
    }

    @And("^I put the checkmark into field 'delete' when \"([^\"]*)\" bigger than zero$")
    public void iPutTheCheckmarkIntoFieldDeleteWhenBiggerThanZero(int count) throws Throwable {
        purchaseMap.putRemoveCheckmark(count);
    }

    @And("^I click on button 'update' when \"([^\"]*)\" bigger than zero$")
    public void iClickOnButtonUpdate(int count) throws Throwable {
        purchaseMap.clickOnUpdateButton(count);
    }

    @Then("^I see the message \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) throws Throwable {
        Assert.assertTrue("!!!", purchaseMap.getTextOfNoProductMessage().contains(message));
    }

    @Then("^From main page in basket title I see \"([^\"]*)\" of products$")
    public void fromMainPageInBasketTitleISeeOfProducts(String count) throws Throwable {
        Runner.driver.get(Parse.URL);
        Assert.assertEquals("!!!", count, Regex.regexCheck(purchaseMap.getTextOfBasketTitle()));
    }
}
