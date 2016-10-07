package com.nix.pageMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lyzenkova on 10/7/2016.
 */
public class AuthorisationMap {

    public WebDriver driver;

    public AuthorisationMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = ".//*[@id='bg-login-block']/a[1]")
    public WebElement authorisation;

    @FindBy (xpath = ".//*[@id='edit-name']")
    public WebElement nameField;

    @FindBy (xpath = ".//*[@id='edit-pass']")
    public WebElement passwordField;

    @FindBy (xpath = ".//*[@id='edit-submit']")
    public WebElement buttonEnter;

    @FindBy (xpath = ".//*[@id='main']/div[2]")
    public WebElement errorMassage;

    @FindBy (xpath = ".//*[@id='bg-login-block']/a[2]")
    public WebElement exitFromUserPage;

    @FindBy (css = ".messages.error")
    public WebElement error;

    public void clickOnButtonEnter(WebElement webElement){
        webElement.click();

    }

}




