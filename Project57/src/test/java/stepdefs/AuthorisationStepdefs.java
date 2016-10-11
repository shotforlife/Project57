package stepdefs;

import pages.mapping.AuthorisationMap;
import runner.Runner;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by lyzenkova on 10/7/2016.
 */
public class AuthorisationStepdefs {

    public AuthorisationMap map = new AuthorisationMap(Runner.driver);

    String expectedURLOfMainPage = "http://www.57.kharkov.ua/";
    String expectedURLOfUserLogin = "http://www.57.kharkov.ua/user/login";
    String expectedURLOfUserPage = "http://www.57.kharkov.ua/user/23104";
    String resultURL;

    @Given("^I'm on start page (\\d+)$")
    public void iMOnStartPage(int arg0) throws Throwable {
        resultURL = Runner.driver.getCurrentUrl();
        if(resultURL == expectedURLOfMainPage){
        }else {
        map.driver.navigate().to(expectedURLOfMainPage);
        }
    }

    @And("^I click link 'authorisation'$")
    public void iClickLinkAuthorisation() throws Throwable {
        map.authorisation.click();
    }

    @And("^I see page for authorisation$")
    public void iSeePageForAuthorisation() throws Throwable {
        resultURL = Runner.driver.getCurrentUrl();
        Assert.assertEquals("Expected user authorisation page didn't load", expectedURLOfUserLogin, resultURL);
    }

    @When("^I click on the Name field$")
    public void iClickOnTheNameField() throws Throwable {
        map.nameField.click();
    }

    @And("^I enter name \"([^\"]*)\"$")
    public void iEnter(String name) throws Throwable {
        map.nameField.sendKeys(name);
    }

    @And("^I click on the Password field$")
    public void iClickOnThePasswordField() throws Throwable {
        map.passwordField.click();
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) throws Throwable {
        map.passwordField.sendKeys(password);
    }

    @And("^I click on the button 'enter'$")
    public void iClickOnTheButtonEnter() throws Throwable {
        map.clickOnButtonEnter(map.buttonEnter);
    }

    @Then("^I get a page of user$")
    public void iGetAPageOfUser() throws Throwable {
        resultURL = Runner.driver.getCurrentUrl();
        Assert.assertEquals("Expected user page didn't load", expectedURLOfUserPage, resultURL);
    }
    @And("^I enter invalid name \"([^\"]*)\"$")
    public void iEnterInvalidName(String name) throws Throwable {
        map.nameField.sendKeys(name);
    }

    @And("^I enter invalid password \"([^\"]*)\"$")
    public void iEnterInvalidPassword(String password) throws Throwable {
        map.passwordField.sendKeys(password);
    }

    @Then("^I get an error massage$")
    public void iGetAnErrorMassage() throws Throwable {
        Assert.assertTrue("Error massage doesn't display",map.errorMassage.isDisplayed());
    }

    @And("^I click on the button 'exit'$")
    public void iClickOnTheButtonExit() throws Throwable {
        map.exitFromUserPage.click();
    }
}
