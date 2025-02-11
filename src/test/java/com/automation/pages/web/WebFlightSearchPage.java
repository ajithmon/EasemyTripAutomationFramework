package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FlightSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFlightSearchPage extends BasePage implements FlightSearchPage {

    @FindBy(id = "FromSector_show")
    WebElement fromCityElement;

    @FindBy(id = "a_FromSector_show")
    WebElement fromCityInput;

    @FindBy(id = "a_Editbox13_show")
    WebElement toCityInput;

    @FindBy(id = "ddate")
    WebElement departureDate;

    @FindBy(css = ".srchBtnSe")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='box']//div[@class='month2']")
    WebElement monthAndYear;

    @FindBy(id = "img2Nex")
    WebElement nextBtn;

    @FindBy(id = "divRtnCal")
    WebElement returnDateElement;

    @FindBy(id="rtrip")
    WebElement roundTripTab;

    String XPATH_DATE_VALUE = "//div[@class='box']//div[@class='days']//li[text()='%s']";
    String ID_CITY_SEARCH_RESULT = "spn%s";


    public boolean isFlightSearchPageDisplayed() {
        return fromCityElement.isDisplayed() && searchBtn.isDisplayed();
    }

    public void enterFromCity(String fromCity) {
        fromCityElement.click();
        fromCityInput.sendKeys(fromCity);
        pause(1000);
        WebElement fromSearchResult = driver.findElement(By.id(String.format(ID_CITY_SEARCH_RESULT, fromCity)));
        waitForElementVisible(fromSearchResult);
        fromSearchResult.click();
    }

    public void enterToCity(String toCity) {
        toCityInput.sendKeys(toCity);
        pause(1000);
        WebElement fromSearchResult = driver.findElement(By.id(String.format(ID_CITY_SEARCH_RESULT, toCity)));
        waitForElementVisible(fromSearchResult);
        fromSearchResult.click();
    }

    public void enterDate(String date) {
        String expMonthYear = getFormattedDate("MMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            System.out.println(expMonthYear);
            System.out.println(actMonthYear);
            nextBtn.click();
            actMonthYear = monthAndYear.getText();
        }

        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
    }


    public void clickOnFlightSearchBtn() {
        searchBtn.click();
    }

    public void clickOnReturnDateElement() {
        returnDateElement.click();
    }

    public boolean isRoundTripTabActivated() {
        return roundTripTab.getAttribute("class").contains("active");
    }
}
