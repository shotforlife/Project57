package stepdefs;

import utils.parser.Parse;
import pages.mapping.PurchaseMap;
import utils.regex.Regex;
import runner.Runner;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @When("^I click on Buy button on some product$")
    public void iClickOnBuyButton() throws Throwable {
        purchaseMap.clickOnBuyButton();
    }

    @Then("^I see that the basket have \"([^\"]*)\" product$")
    public void iSeeThatTheBasketHaveProduct(int count) throws Throwable {
        Assert.assertEquals("!!!", String.valueOf(count), purchaseMap.ProductsQuantity.getAttribute("value"));

    }
    
    @When("^I am in the basket$")
    public void iAmInTheBasket() throws Throwable {
        purchaseMap.getBasket();
    }

    @And("^I put the checkmark into field 'delete'$")
    public void iPutTheCheckmarkIntoFieldDelete() throws Throwable {
        purchaseMap.putRemoveCheckmark();
    }

    @And("^I click on button 'update'$")
    public void iClickOnButtonUpdate() throws Throwable {
        purchaseMap.clickOnUpdateButton();
    }

    @Then("^I see the message \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) throws Throwable {
        Assert.assertTrue("!!!", purchaseMap.NoProductsMessage.getText().contains(message));
    }

    @Given("^I get the number of products in basket$")
    public void iGetTheNumberOfProductsInBasket(String count) throws Throwable {
        Assert.assertEquals("!!!", count, Regex.regexCheck(purchaseMap.getTextOfBasketTitle()));
    }

    @And("^From main page in basket title I see \"([^\"]*)\" of products$")
    public void fromMainPageInBasketTitleISeeOfProducts(String count) throws Throwable {
        Runner.driver.get(Parse.URL);
        Assert.assertEquals("!!!", count, Regex.regexCheck(purchaseMap.getTextOfBasketTitle()));
    }

}
