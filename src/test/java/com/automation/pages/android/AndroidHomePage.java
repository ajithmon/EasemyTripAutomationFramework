package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    WebElement flightTab;

    public void openApplication() {
        System.out.println("hi");
    }

    public boolean isHomePageDisplayed() {
        return  flightTab.isDisplayed();
    }

    public void clickOnFlightTab() {
        flightTab.click();
    }
}
