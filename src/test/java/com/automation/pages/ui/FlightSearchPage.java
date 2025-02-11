package com.automation.pages.ui;

public interface FlightSearchPage {
    boolean isFlightSearchPageDisplayed();
    void clickOnReturnDateElement();
    boolean isRoundTripTabActivated();

    void enterFromCity(String configValue);

    void enterToCity(String configValue);

    void enterDate(String configValue);

    void clickOnFlightSearchBtn();

}
