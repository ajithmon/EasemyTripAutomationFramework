package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FlightBookingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFlightBookingPage extends BasePage implements FlightBookingPage {

    @FindBy(id = "lblCpnEMTUPIVM")
    WebElement coupon;

    @FindBy(id="spnCouponDst")
    WebElement couponAmount;

    @FindBy(id = "spnApply")
    WebElement apply;

    @FindBy(xpath = "//span[@ng-bind='CurrencyDisplayRate(pf.BscFare)']")
    WebElement cost;

    @FindBy(xpath = "//span[@ng-bind='CurrencyDisplayRate(TtlDisplayTax)']")
    WebElement tax;

    @FindBy(xpath = "//span[@id='spnGrndTotal']1")
    WebElement total;

    public boolean isFlightBookingPageDisplayed(){
        return apply.isDisplayed();
    }
    public void userApplyCoupon(){
        coupon.click();
    }
    public int verifyFinalPrice(){
        int totalPrice=Integer.parseInt(cost.getText())+Integer.parseInt(tax.getText())-Integer.parseInt(couponAmount.getText());
        return totalPrice;
    }
    public int totalPriceAfterOffer(){
        String value=total.getText().replace(",","");
        int totalAmount=Integer.parseInt(value);
        return totalAmount;
    }
}
