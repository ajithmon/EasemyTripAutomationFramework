package com.automation.pages.ui;

public interface FlightListingPage {
    boolean isFlightListingPageDisplayed();

    void selectFilterOption(String configValue);

    boolean isFlightListingDisplayedWithFilter(String configValue);

    void userClickOnBookNowButton();
}
