package com.nix.pageMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mukhin on 10/10/2016.
 */
public class SearchMap {
    public WebDriver driver;

    public SearchMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='edit-title']")
    public WebElement SearchField;

    @FindBy(xpath = ".//*[@id='edit-submit-search']")
    public WebElement SearchButton;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div/div/ul/li/div/div[2]/div[1]")
    public WebElement SearchResults;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div/p")
    public WebElement NoResults;

    public void clickOnSearchButton() {
        SearchButton.click();
    }

    public void pickOutSearchField() {
        SearchField.click();
    }

    public void sendKeys(String keys) {
        SearchField.sendKeys(keys);
    }
}
