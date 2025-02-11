package com.automation.pages.ui;

public interface FlightBookingPage {
    int verifyFinalPrice();
    void userApplyCoupon();
    boolean isFlightBookingPageDisplayed();
    int totalPriceAfterOffer();
}
