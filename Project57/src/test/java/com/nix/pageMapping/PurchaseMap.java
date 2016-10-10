package com.nix.pageMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Created by mukhin on 10/10/2016.
 */
public class PurchaseMap {
    public WebDriver driver;

    public PurchaseMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='block-jquerymenu-1']/div/ul/li[2]/ul/li[2]/a")
    public WebElement Processors;

    @FindBy(xpath = ".//*[@id='edit-submit-66998']")
    public WebElement BuyButton;

    @FindBy(xpath = ".//*[@id='cart-block-products']/a")
    public WebElement Basket;

    @FindBy(xpath = ".//*[@id='edit-items-0-qty']")
    public WebElement ProductsQuantity;

    @FindBy(xpath = ".//*[@id='edit-items-0-remove']")
    public WebElement RemoveCheckmark;

    @FindBy(xpath = ".//*[@id='edit-update']")
    public WebElement UpdateButton;

    @FindBy(xpath = ".//*[@id='main']/p")
    public WebElement NoProductsMessage;

    @FindBy (xpath = ".//*[@id='cart-block-products']")
    public WebElement BasketTitle;

    public void clickOnUpdateButton() {
        UpdateButton.click();
    }

    public void putRemoveCheckmark() {
        RemoveCheckmark.click();
    }

    public void getProductList() {
        Processors.click();
    }

    public void getBasket() {
        Basket.click();
    }

    public void clickOnBuyButton() {
        BuyButton.click();
    }
}
