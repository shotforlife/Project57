package pages.mapping;

import utils.parser.Parse;
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
    private WebDriver driver;

    public MainPageMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='logo']")
    private WebElement Logo;

    @FindBy(xpath = ".//*[@id='cart-block-products']/a")
    private WebElement Basket;

    @FindBy(xpath = ".//*[@id='cart-block-links']//a[contains(text(),\"Сервисные\")]")
    private WebElement Srvc;

    @FindBy(xpath = ".//*[@id='cart-block-links']//a[contains(text(),\"Доставка\")]")
    private WebElement Delivery;

    @FindBy(xpath = ".//*[@id='cart-block-links']//a[text()=\"Контакты\"]")
    private WebElement Contacts;

    @FindBy(xpath = ".//*[@id='cart-block-links']//a[text()=\"Услуги\"]")
    private WebElement Service;

    @FindBy(xpath = ".//*[@id='block-block-1']//a[contains(text(),\"Задать\")]")
    private WebElement Question;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[text()=\"Комплектующие\"]")
    private WebElement Parts;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[text()=\"Компьютеры\"]")
    private WebElement Computers;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[text()=\"Периферия\"]")
    private WebElement Periphery;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[contains(text(),\"Личная\")]")
    private WebElement Personal;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[contains(text(),\"ТВ\")]")
    private WebElement TV;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[contains(text(),\"Бытовая\")]")
    private WebElement Houshold;

    @FindBy(xpath = ".//*[@id='block-custom_catalog-catalog_block']//a[text()=\"Разное\"]")
    private WebElement Other;

    @FindBy(xpath = ".//*[@id='block-block-2']//a[text()=\"Кредит\"]")
    private WebElement Credit;

    @FindBy(xpath = ".//*[@id='community_header']/div/a")
    private WebElement Social;

    @FindBy(xpath = ".//*[@id='block-views-new_products-block_1']/h3/span")
    private WebElement MainPageTitle;

    @FindBy(xpath = ".//*[@id='main']/h2")
    private WebElement PagesTitles;

    @FindBy(xpath = ".//*[@id='page_info_wrap']/div/h2")
    private WebElement SocialTitle;

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
            case "Social": {
                driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='vkwidget1']")));
                Social.click();
            }
        }
    }

    public String getTextOfElement(WebDriver driver) {

        if (driver.getCurrentUrl().contains(Parse.URL)) {
            if (driver.getCurrentUrl().equals(Parse.URL)) {
                return MainPageTitle.getText();
            } else {
                return PagesTitles.getText();
            }
        } else {
            return SocialTitle.getText();
        }
    }

}
