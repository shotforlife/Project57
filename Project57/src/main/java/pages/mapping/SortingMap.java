package pages.mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.regex.Regex.regexReadingPrice;

/**
 * Created by lyzenkova on 10/10/2016.
 */
public class SortingMap {

    private WebDriver driver;

    public SortingMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='block-jquerymenu-1']//a[contains(text(), \"AMD\")]")
    private WebElement processorAMDLink;

    @FindBy(xpath = ".//*[@id='main']//a[contains(text(), \"возрастанию\")]")
    private WebElement ascendingLink;

    @FindBy(xpath = ".//*[@id='main']//a[contains(text(), \"убыванию\")]")
    private WebElement descendingLink;

    @FindBy(xpath = ".//*[@id='main']//div[@class='sell-price']")
    private List<WebElement> prices;

    @FindBy(xpath = ".//*[@id='main']//a[contains(text(), \"наличии\")]")
    private WebElement stockLink;

    @FindBy(xpath = ".//*[@id='main']/h2")
    private WebElement processorAMDTitle;

    public void clickLinkProcessor() {
        processorAMDLink.click();
    }

    public void clickAscendingLink() {
        ascendingLink.click();
    }

    public void clickDescendingLink() {
        descendingLink.click();
    }

    public void clickStockLink() {
        stockLink.click();
    }

    public boolean checkTitleProcessorAMD() {
        return processorAMDTitle.getText().contains("Процессоры");
    }

    public double[] writingPricesList() {
        double[] listOfPrices = new double[prices.size()];
        try {
            for (int i = 0; i < prices.size(); i++) {
                listOfPrices[i] = regexReadingPrice(prices.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfPrices;
    }

    public boolean checkingSortDes(double[] list) {
        try {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkingSortAsc(double[] list) {
        try {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] < list[i + 1]){
                } else {
                    return false;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
