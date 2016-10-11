package pages.mapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lyzenkova on 10/10/2016.
 */
public class SortingMap {

    public WebDriver driver;
    double readingPrice;
    String attribute;


    public SortingMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = ".//*[@id='block-jquerymenu-1']/div/ul/li[2]/ul/li[1]/a")
    public WebElement processorAMDLink;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div[1]/div/div/div/div[8]/a[2]")
    public WebElement ascendingLink;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div[1]/div/div/div/div[8]/a[3]")
    public WebElement descendingLink;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div[2]/ul/li[1]/div/div[3]/div[1]")
    public WebElement firstPrice;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div[2]/ul/li[2]/div/div[3]/div[1]")
    public WebElement secondPrice;

    @FindBy (xpath = ".//*[@id='main']/div[2]/div[2]/ul/li[5]/div/div[3]/div[1]")
    public WebElement thirdPrice;



    public double readingPrise(WebElement webElement){
        attribute = webElement.getText();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(attribute);
        StringBuilder sb = new StringBuilder();
        while (m.find()){
            String bw = m.group().toString();
            sb.append(bw);
        }
        String s = new String(sb);
        readingPrice = new Double(s);
        return readingPrice;
    }

    public boolean checkingForAscending(double firstPr, double secondPr){
        if(firstPr < secondPr){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkingForDescending(double firstPr, double secondPr){
        if(firstPr > secondPr){
            return true;
        } else {
            return false;
        }
    }
}
