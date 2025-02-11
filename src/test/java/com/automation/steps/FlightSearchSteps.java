package com.automation.steps;

import com.automation.pages.android.AndroidFlightSearchPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.FlightSearchPage;
import com.automation.pages.web.WebFlightSearchPage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightSearchSteps {
    FlightSearchPage flightSearchPage;
    public FlightSearchSteps() {
        if (System.getProperty("platform").equals("web")) {
            flightSearchPage = new WebFlightSearchPage();
        } else {
            flightSearchPage= new AndroidFlightSearchPage();
        }
    }

    @Then("verify flight search page is displayed")
    public void verifyFlightSearchPageIsDisplayed() {
        Assert.assertTrue(flightSearchPage.isFlightSearchPageDisplayed());
    }

    @When("user search flight with from city {string} and to city {string} with date {string}")
    public void userSearchFlightWithFromCityAndToCityWithDate(String fromCity, String toCity, String date) {
        flightSearchPage.enterFromCity(ConfigReader.getConfigValue(fromCity));
        flightSearchPage.enterToCity(ConfigReader.getConfigValue(toCity));
        flightSearchPage.enterDate(ConfigReader.getConfigValue(date));
        flightSearchPage.clickOnFlightSearchBtn();
    }

    @When("user select return date {string}")
    public void userSelectReturnDate(String date) {
        flightSearchPage.clickOnReturnDateElement();
        flightSearchPage.enterDate(ConfigReader.getConfigValue(date));
    }

    @Then("verify round trip tab is activated")
    public void verifyRoundTripTabIsActivated() {
        Assert.assertTrue(flightSearchPage.isRoundTripTabActivated());
    }
}
