package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends BasePage implements HomePage {

    @FindBy(xpath = "//a/span[text()='Flights']")
    WebElement flightTab;

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isHomePageDisplayed() {
        // We don't have homepage in Web
        return true;
    }

    public void clickOnFlightTab() {
        flightTab.click();
    }
}
