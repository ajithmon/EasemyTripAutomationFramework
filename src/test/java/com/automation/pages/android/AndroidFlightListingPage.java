package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FlightListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class AndroidFlightListingPage extends AndroidBasePage implements FlightListingPage {

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/flight_details']")
    List<WebElement> listOfFlightNames;

    @FindBy(id = "com.easemytrip.android:id/tv_name_Airline")
    List<WebElement> filterOptionValues;

    @FindBy(xpath = "//android.widget.TextView[@text='More Filters']")
    WebElement filter;

    @FindBy(id = "com.easemytrip.android:id/btn_ApplyFilter")
    WebElement apply;

    @FindBy(id = "com.easemytrip.android:id/tv_flight_name")
    WebElement flightName;

    @FindBy(xpath = "//android.widget.TextView[@text='Book Now']")
    WebElement bookNowBtn;


    public boolean isFlightListingPageDisplayed() {
        return listOfFlightNames.size() > 0;
    }

    public void selectFilterOption(String filterOption) {
        filter.click();
        scrollPage();
        for (WebElement filter : filterOptionValues) {
            if (filter.getText().trim().equalsIgnoreCase(filterOption)) {
                filter.click();
            }
        }
        apply.click();
    }

    public boolean isFlightListingDisplayedWithFilter(String filterOption) {
        int i=1;
        while(i<2) {
            for (WebElement flight : listOfFlightNames) {
                String input = flight.findElement(By.id("com.easemytrip.android:id/tv_flight_name")).getText();
                String airline = input.split("\\|")[0].trim();
                System.out.println("==> " + airline);
                if (!airline.equalsIgnoreCase(filterOption)) {
                    return false;
                }
            }
            scrollPage();
            listOfFlightNames = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/flight_details']"));
            i++;
        }
        return true;
    }

    public void userClickOnBookNowButton(){
        listOfFlightNames.get(0).click();
        bookNowBtn.click();
        pause(3000);
        for(int i=0;i<4;i++){
            scrollPage();
        }
        pause(3000);
    }
}