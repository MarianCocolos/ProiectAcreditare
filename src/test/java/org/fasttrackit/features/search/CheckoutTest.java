package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void addCouponDiscount(){
        shopSteps.addProductToCart("Album");
        cartSteps.changeQuantity("2");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.verifySuccessAddCouponMessage("Coupon code applied successfully.");
    }

    @Test
    public void verifyGrandTotalPriceWithDiscountAndShipping(){
        checkoutSteps.addProductsToCart();
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.checkCartSubtotalIsCorrect();
        checkoutSteps.checkCartGrandTotalIsCorrect();
    }

    @Test
    public void verifyPlaceAOrder(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        checkoutSteps.addProductToCart("Beanie");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.completeBillingDetails();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyOrderConfirmation("ORDER RECEIVED");
    }

    @Test
    public void removeCouponDiscount(){
        shopSteps.addProductToCart("Cap");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.clickRemoveCouponButton();
        checkoutSteps.verifySuccessRemoveCouponMessage("Coupon has been removed.");
    }

    @Test
    public void verifyCheckoutWithoutPhoneNumber(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        checkoutSteps.addProductToCart("Beanie");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.completeBillingDetailsWithoutPhoneNumber();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyMissingPhoneMessage("Billing Phone is a required field.");
    }

}
