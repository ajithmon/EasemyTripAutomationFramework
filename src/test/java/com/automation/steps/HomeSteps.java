package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage;

    public HomeSteps() {
        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new AndroidHomePage();
        }
    }

    @Given("user open application")
    public void userOpenApplication() {
        homePage.openApplication();
    }

    @Then("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user click on Flight Tab")
    public void userClickOnFlightTab() {
        homePage.clickOnFlightTab();
    }

}
