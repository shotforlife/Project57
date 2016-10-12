package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.mapping.AuthorizationMap;
import runner.Runner;

/**
 * Created by lyzenkova on 10/7/2016.
 */
public class AuthorizationStepdefs {

    private AuthorizationMap authorizationMap = new AuthorizationMap(Runner.driver);

    String expectedURLOfMainPage = "http://www.57.kharkov.ua/";
    String resultURL;
    boolean result;

    @Given("^I'm on start page of internet site '(\\d+)'$")
    public void iMOnStartPageOfInternetSite(int arg0) throws Throwable {
        Runner.driver.navigate().to(expectedURLOfMainPage);
        resultURL = Runner.driver.getCurrentUrl();
        if(resultURL == expectedURLOfMainPage){
        }else {
            authorizationMap.driver.navigate().to(expectedURLOfMainPage);
        }
        Assert.assertTrue("Expected title on the start page wasn't find", authorizationMap.checkTitleStartPage());
    }

    @When("^I click link \"([^\"]*)\"$")
    public void iClickLinkAuthorization(String link) throws Throwable {
        authorizationMap.clickOnButton(link);
    }

    @And("^I see page for authorization that has title authorization profile$")
    public void iSeePageForAuthorization() throws Throwable {
        Assert.assertTrue("Expected user authorisation page didn't load", authorizationMap.checkTitleForAuthorizationProfile());
    }

    @When("^I click on the Name field$")
    public void iClickOnTheNameField() throws Throwable {
        authorizationMap.clickFieldName();
    }

    @And("^I enter name \"([^\"]*)\"$")
    public void iEnter(String name) throws Throwable {
        authorizationMap.enterName(name);
    }

    @And("^I click on the Password field$")
    public void iClickOnThePasswordField() throws Throwable {
        authorizationMap.clickFieldPassword();
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) throws Throwable {
        authorizationMap.enterPassword(password);
    }

    @And("^I click on the \"([^\"]*)\" button$")
    public void iClickOnTheButtonEnter(String button) throws Throwable {
        authorizationMap.clickOnButton(button);
    }

    @Then("^I get a page of user that has title \"([^\"]*)\"$")
    public void iGetAPageOfUser(String name) throws Throwable {
        String title = authorizationMap.getTitleForUser();
        Assert.assertEquals("Expected user page didn't load", name, title);
    }
    @And("^I enter invalid name \"([^\"]*)\"$")
    public void iEnterInvalidName(String name) throws Throwable {
        authorizationMap.enterName(name);
    }

    @And("^I enter invalid password \"([^\"]*)\"$")
    public void iEnterInvalidPassword(String password) throws Throwable {
        authorizationMap.enterPassword(password);
    }

    @Then("^I get an error massage$")
    public void iGetAnErrorMassage() throws Throwable {
        Assert.assertTrue("Error massage doesn't display",authorizationMap.checkErrorTitle());
    }

    @And("^I click on the button 'exit'$")
    public void iClickOnTheButtonExit(String button) throws Throwable {
        authorizationMap.clickOnButton(button);
    }

}
