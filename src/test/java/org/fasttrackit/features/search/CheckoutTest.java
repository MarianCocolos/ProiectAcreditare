package org.fasttrackit.features.search;

import org.junit.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void addCouponDiscount(){
        shopSteps.addProductToCart("Long Sleeve Tee");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.verifySuccessAddCouponMessage();
    }

    @Test
    public void verifyGrandTotalPriceWithDiscount(){
        checkoutSteps.addProductsToCart();
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.checkCartSubtotalIsCorrect();
        checkoutSteps.checkCartGrandTotalIsCorrect();
    }

    @Test
    public void removeCouponDiscount(){
        shopSteps.addProductToCart("Cap");
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.addCoupon("fixed cart discount");
        checkoutSteps.clickRemoveCouponButton();
        checkoutSteps.verifySuccessRemoveCouponMessage();
    }

}
