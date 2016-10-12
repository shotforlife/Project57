package pages.mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement ProductsQuantity;

    @FindBy(xpath = ".//*[@id='edit-items-0-remove']")
    private WebElement RemoveCheckmark;

    @FindBy(xpath = ".//*[@id='edit-update']")
    private WebElement UpdateButton;

    @FindBy(xpath = ".//*[@id='main']/p")
    private WebElement NoProductsMessage;

    @FindBy(xpath = ".//*[@id='cart-block-products']")
    private WebElement BasketTitle;

    public void clickOnUpdateButton(int count) {
        if (count != 0)
            UpdateButton.click();
    }

    public void putRemoveCheckmark(int count) {
        if (count != 0)
            RemoveCheckmark.click();
    }

    public void getProductList() {
        Processors.click();
    }

    public void getBasket() {
        Basket.click();
    }

    public void clickOnBuyButton(int count) {
        for (int i = 0; i < count; i++) {
            BuyButton.click();
            driver.navigate().back();
        }
    }

    public String getTextOfBasketTitle() {
        return BasketTitle.getText();
    }

    public String getTextOfNoProductMessage() {
        return NoProductsMessage.getText();
    }

    public String getProductsQuantityAttribute(String attribute, int count) {
        while (count == 0) {
            if (NoProductsMessage.isDisplayed()) {
                return "0";
            }
        }
        return ProductsQuantity.getAttribute(attribute);
    }
}
