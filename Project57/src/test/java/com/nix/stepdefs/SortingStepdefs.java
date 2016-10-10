package com.nix.stepdefs;

import com.nix.pageMapping.SortingMap;
import com.nix.runner.Runner;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by lyzenkova on 10/10/2016.
 */
public class SortingStepdefs {

    private SortingMap sortingMap = new SortingMap(Runner.driver);
    private String expectedURLProcessorAMD = "http://www.57.kharkov.ua/catalog/parts/cpu_amd";
    private String resultURL;
    boolean expected = true;
    double firstPrice;
    double secondPrice;
    double thirdPrice;
    
    @And("^I click link 'processor AMD'$")
    public void iClickLinkProcessorAMD() throws Throwable {
        sortingMap.processorAMDLink.click();
    }
    
    @And("^I see page of goods 'processor AMD'$")
    public void iSeePageOfGoodsProcessorAMD() throws Throwable {
        resultURL = Runner.driver.getCurrentUrl();
        Assert.assertEquals("Expected page of processor AMD didn't load", resultURL, expectedURLProcessorAMD);
    }

    @When("^I click on the 'descending' link$")
    public void iClickOnTheDescendingLink() throws Throwable {
        sortingMap.descendingLink.click();
    }

    @And("^I check that prise of first product more than prise of second product$")
    public void iCheckThatPriseOfFirstProductMoreThanPriseOfSecondProduct() throws Throwable {
        boolean real;
        firstPrice = sortingMap.readingPrise(sortingMap.firstPrice);
        secondPrice = sortingMap.readingPrise(sortingMap.secondPrice);
        real = sortingMap.checkingForDescending(firstPrice, secondPrice);
        Assert.assertEquals("001 Fist price doesn't more than second price", real, expected);
    }

    @Then("^I check that prise of second product more than prise of third product$")
    public void iCheckThatPriseOfSecondProductMoreThanPriseOfThirdProduct() throws Throwable {
        boolean real;
        thirdPrice = sortingMap.readingPrise(sortingMap.thirdPrice);
        real = sortingMap.checkingForDescending(secondPrice, thirdPrice);
        Assert.assertEquals("001 Second price doesn't more than third price", real, expected);
    }

    @When("^I click on the 'ascending' link$")
    public void iClickOnTheAscendingLink() throws Throwable {
        sortingMap.ascendingLink.click();
    }

    @And("^I check that prise of first product less than prise of second product$")
    public void iCheckThatPriseOfFirstProductLessThanPriseOfSecondProduct() throws Throwable {
        boolean real;
        firstPrice = sortingMap.readingPrise(sortingMap.firstPrice);
        secondPrice = sortingMap.readingPrise(sortingMap.secondPrice);
        real = sortingMap.checkingForAscending(firstPrice, secondPrice);
        Assert.assertEquals("002 Fist price doesn't less than second price", real, expected);
    }

    @Then("^I check that prise of second product less than prise of third product$")
    public void iCheckThatPriseOfSecondProductLessThanPriseOfThirdProduct() throws Throwable {
        boolean real;
        thirdPrice = sortingMap.readingPrise(sortingMap.thirdPrice);
        real = sortingMap.checkingForAscending(secondPrice, thirdPrice);
        Assert.assertEquals("001 Second price doesn't less than third price", real, expected);
    }
}
