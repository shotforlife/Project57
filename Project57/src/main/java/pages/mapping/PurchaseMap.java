package pages.mapping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Created by mukhin on 10/10/2016.
 */
public class PurchaseMap {
    private WebDriver driver;

    public PurchaseMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='block-jquerymenu-1']//a[contains(text(), \"Intel\")]")
    private WebElement Processors;

    @FindBy(xpath = ".//*[@id='edit-submit-66998']")
    private WebElement BuyButton;

    @FindBy(xpath = ".//*[@id='cart-block-products']/a")
    private WebElement Basket;

    @FindBy(xpath = ".//*[@id='edit-items-0-qty']")
    public WebElement ProductsQuantity;

    @FindBy(xpath = ".//*[@id='edit-items-0-remove']")
    private WebElement RemoveCheckmark;

    @FindBy(xpath = ".//*[@id='edit-update']")
    private WebElement UpdateButton;

    @FindBy(xpath = ".//*[@id='main']/p")
    public WebElement NoProductsMessage;

    @FindBy (xpath = ".//*[@id='cart-block-products']")
    private WebElement BasketTitle;

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

    public String getTextOfBasketTitle () {
        return BasketTitle.getText();
    }
}
