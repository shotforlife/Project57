package pages.mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lyzenkova on 10/7/2016.
 */
public class AuthorizationMap {

    public WebDriver driver;

    public AuthorizationMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = ".//*[@id='bg-login-block']/a[text()=\"Авторизируйтесь\"]")
    private WebElement authorisation;

    @FindBy (xpath = ".//*[@id='edit-name']")
    private WebElement nameField;

    @FindBy (xpath = ".//*[@id='edit-pass']")
    private WebElement passwordField;

    @FindBy (xpath = ".//*[@id='edit-submit']")
    private WebElement buttonEnter;

    @FindBy (xpath = ".//*[@id='main']/div[@class=\"messages error\"]")
    private WebElement errorMassage;

    @FindBy (xpath = ".//*[@id='bg-login-block']/a[text()=\"Выйти\"]")
    private WebElement exitFromUserPage;

    @FindBy (xpath = ".//*[@id='bg-login-block']/a[1]")
    private WebElement titleForUser;

    @FindBy (xpath = ".//*[@id='main']/h2")
    private WebElement authorizationProfile;

    @FindBy (xpath = ".//*[@id='block-views-new_products-block_1']/h3/span")
    private WebElement startPageTitle;

    public void clickOnButton(String button){
        switch (button){
            case "Enter": {
                buttonEnter.click();
                break;
            }
            case "Exit": {
                exitFromUserPage.click();
                break;
            }
            case "Authorization": {
                authorisation.click();
                break;
            }
        }
    }

    public String getTitleForUser(){
        return titleForUser.getText();
    }
    public boolean checkTitleStartPage(){
        return startPageTitle.getText().contains("Новые поступления");
    }

    public boolean checkTitleForAuthorizationProfile(){
        return authorizationProfile.isDisplayed();
    }

    public boolean checkErrorTitle(){
        return errorMassage.isDisplayed();
    }

    public void clickFieldName(){
        nameField.click();
    }

    public void clickFieldPassword(){
        passwordField.click();
    }

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

}




