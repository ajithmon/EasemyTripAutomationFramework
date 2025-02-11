package com.automation.steps;

import com.automation.pages.android.AndroidFlightBookingPage;
import com.automation.pages.android.AndroidFlightListingPage;
import com.automation.pages.ui.FlightBookingPage;
import com.automation.pages.ui.FlightListingPage;
import com.automation.pages.web.WebFlightBookingPage;
import com.automation.pages.web.WebFlightListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightBookingSteps {
   FlightBookingPage flightBookingPage;
    public FlightBookingSteps() {
        if (System.getProperty("platform").equals("web")) {
            flightBookingPage= new WebFlightBookingPage();
        } else {
            flightBookingPage= new AndroidFlightBookingPage();
        }
    }

    @Then("verify user is on flight booking page")
    public void verifyUserIsOnFlightBookingPage() {

        Assert.assertTrue(flightBookingPage.isFlightBookingPageDisplayed());
    }

    @When("user apply coupon on flight")
    public void userApplyCouponOnFlight() {
        flightBookingPage.userApplyCoupon();
    }

    @Then("verify coupon is applied and price changed")
    public void verifyCouponIsAppliedAndPriceChanged() {
        Assert.assertEquals(flightBookingPage.verifyFinalPrice(),flightBookingPage.totalPriceAfterOffer());
    }
}
