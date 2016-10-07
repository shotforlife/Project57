package com.nix.pageMapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

/**
 * Created by mukhin on 10/7/2016.
 */
public class MainPageMap {
    public WebDriver driver;

    public MainPageMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = ".//*[@id='logo']")
    public WebElement Logo;

    @FindBy (xpath = ".//*[@id='cart-block-products']/a")
    public WebElement Basket;

    @FindBy (xpath = ".//*[@id='cart-block-links']/li[1]/a")
    public  WebElement Srvc;

    @FindBy (xpath = ".//*[@id='cart-block-links']/li[3]/a")
    public WebElement Delivery;

    @FindBy (xpath = ".//*[@id='cart-block-links']/li[4]/a")
    public WebElement Contacts;

    @FindBy (xpath = ".//*[@id='cart-block-links']/li[2]/a")
    public WebElement Service;

    @FindBy (xpath = ".//*[@id='block-block-1']/div/p/a[1]")
    public WebElement Question;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[1]/a")
    public WebElement Parts;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[3]/a")
    public WebElement Computers;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[2]/a")
    public WebElement Periphery;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[4]/a")
    public WebElement Personal;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[5]/a")
    public WebElement TV;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[6]/a")
    public WebElement Houshold;

    @FindBy (xpath = ".//*[@id='block-custom_catalog-catalog_block']/div/ul/li[7]/a")
    public WebElement Other;

    @FindBy (xpath = ".//*[@id='block-block-2']/div/p/a[2]")
    public WebElement Credit;

    @FindBy (xpath = ".//*[@id='community_header']/div/a")
    public WebElement Social;

    public void clickOnButton(String buttonName) throws Exception {

        switch (buttonName) {
            case "Logo": {
                Logo.click();
                break;
            }
            case "Basket": {
                Basket.click();
                break;
            }
            case "Srvc": {
                Srvc.click();
                break;
            }
            case "Delivery": {
                Delivery.click();
                break;
            }
            case "Contacts": {
                Contacts.click();
                break;
            }
            case "Service": {
                Service.click();
                break;
            }
            case "Question": {
                Question.click();
                break;
            }
            case "Parts": {
                Parts.click();
                break;
            }
            case "Computers": {
                Computers.click();
                break;
            }
            case "Periphery": {
                Periphery.click();
                break;
            }
            case "Personal": {
                Personal.click();
                break;
            }
            case "TV": {
                TV.click();
                break;
            }
            case "Houshold": {
                Houshold.click();
                break;
            }
            case "Other": {
                Other.click();
                break;
            }
            case "Credit": {
                Credit.click();
                break;
            }
            case "Social" : {
                driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='vkwidget1']")));
                Social.click();
            }
        }
    }

}
