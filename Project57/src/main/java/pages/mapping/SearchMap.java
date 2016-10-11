package pages.mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mukhin on 10/10/2016.
 */
public class SearchMap {
    private WebDriver driver;

    public SearchMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='edit-title']")
    private WebElement SearchField;

    @FindBy(xpath = ".//*[@id='edit-submit-search']")
    private WebElement SearchButton;

    @FindBy(xpath = ".//*[@id='main']//div[@class=\"views-field-title\"]")
    private WebElement SearchResults;

    @FindBy(xpath = ".//*[@id='main']//p[contains(text(),\"Ничего\")]")
    private WebElement NoResults;

    public void clickOnSearchButton() {
        SearchButton.click();
    }

    public void pickOutSearchField() {
        SearchField.click();
    }

    public void sendKeys(String keys) {
        SearchField.sendKeys(keys);
    }

    public String getTextOfSearchResult() {
        return SearchResults.getText();
    }

    public String getTextOfNoResult() {
        return NoResults.getText();
    }
}
