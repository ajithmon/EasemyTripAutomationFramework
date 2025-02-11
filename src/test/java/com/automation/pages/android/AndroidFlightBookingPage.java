package com.automation.pages.android;

import com.automation.pages.ui.FlightBookingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightBookingPage extends AndroidBasePage implements FlightBookingPage {

    @FindBy(id="com.easemytrip.android:id/button_applycoupon")
    WebElement apply;

    @FindBy(id="com.easemytrip.android:id/tvCode")
    WebElement coupon;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Continue Booking\"]")
    WebElement continueBtn;

    @FindBy(id="com.easemytrip.android:id/tv_total_base_amt")
    WebElement baseAmount;

    @FindBy(id="com.easemytrip.android:id/tv_surcharges_amt")
    WebElement tax;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_total_amt']")
    WebElement total;

    @FindBy(id="com.easemytrip.android:id/tv_coupon_amt")
    WebElement couponAmount;

    @FindBy(id="com.easemytrip.android:id/grand_total_traveller")
    WebElement priceScript;

    @FindBy(id="com.easemytrip.android:id/button_remove_coupon")
    WebElement remove;

    public boolean isFlightBookingPageDisplayed(){
        remove.click();
        return apply.isDisplayed();
    }
    public void userApplyCoupon(){
        coupon.click();
        pause(1000);
        priceScript.click();
    }
    public int verifyFinalPrice(){
        int totalPrice=Integer.parseInt(baseAmount.getText().replaceAll("[^a-zA-Z0-9]", ""))+Integer.parseInt(tax.getText().replaceAll("[^a-zA-Z0-9]", ""))-Integer.parseInt(couponAmount.getText().replaceAll("[^0-9]", ""));
        return totalPrice;
    }
    public int totalPriceAfterOffer(){
        int totalAmount=Integer.parseInt(total.getText().replaceAll("[^0-9]", ""));
        return totalAmount;
    }
}
