package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FlightSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightSearchPage extends AndroidBasePage implements FlightSearchPage {

    @FindBy(id = "com.easemytrip.android:id/search_flight_origin_code")
    WebElement fromCityElement;

    @FindBy(id = "com.easemytrip.android:id/edt_depart_airport")
    WebElement fromCityInput;

    @FindBy(id = "com.easemytrip.android:id/search_flight_destination_code")
    WebElement toCityElement;

    @FindBy(id = "com.easemytrip.android:id/edt_arrival_airport")
    WebElement toCityInput;

    @FindBy(id = "com.easemytrip.android:id/search_flight_departure_date")
    WebElement departureDate;

    @FindBy(id = "com.easemytrip.android:id/button_flight_Search")
    WebElement searchBtn;

    @FindBy(id = "com.easemytrip.android:id/tvMonthName")
    WebElement monthAndYear;

    @FindBy(id = "img2Nex")
    WebElement nextBtn;

    @FindBy(id = "com.easemytrip.android:id/search_flight_return_date")
    WebElement returnDateElement;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.easemytrip.android:id/rdbRoundtrip']")
    WebElement roundTripTab;

    String XPATH_DATE_VALUE = "//android.widget.TextView[@text='%s']";
    //String ID_CITY_SEARCH_RESULT = "spn%s";

    @FindBy(id = "com.easemytrip.android:id/search_airport_list_item_name")
    WebElement airport;


    public boolean isFlightSearchPageDisplayed() {
        return fromCityElement.isDisplayed() && searchBtn.isDisplayed();
    }

    public void enterFromCity(String fromCity) {
        fromCityElement.click();
        fromCityInput.sendKeys(fromCity);
        pause(1000);
        airport.click();
       // WebElement fromSearchResult = driver.findElement(By.id(String.format(ID_CITY_SEARCH_RESULT, fromCity)));
       // waitForElementVisible(fromSearchResult);//fromSearchResult.click();
    }

    public void enterToCity(String toCity) {
        toCityElement.click();
        toCityInput.sendKeys(toCity);
        pause(1000);
        airport.click();
//        WebElement fromSearchResult = driver.findElement(By.id(String.format(ID_CITY_SEARCH_RESULT, toCity)));
//        waitForElementVisible(fromSearchResult);
//        fromSearchResult.click();
    }

    public void enterDate(String date) {
        departureDate.click();
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            System.out.println(expMonthYear);
            System.out.println(actMonthYear);
            scrollPage();
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
        //return roundTripTab.getAttribute("class").contains("active");
        return roundTripTab.getAttribute("checked").contains("true");
    }
}
