package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.CheckoutPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.ShopPage;
import org.junit.Assert;

public class CheckoutSteps extends ScenarioSteps {

    private CheckoutPage checkoutPage;
    private HomePage homePage;
    private ShopPage shopPage;
    private ProductPage productPage;


    @Step
    public void verifyProceedToCheckoutSuccess(String text){checkoutPage.verifyCheckoutPageTitle(text);}
    @Step
    public void addCoupon(String couponName){
        checkoutPage.clickOnCuponLink();
        checkoutPage.completeCouponField(couponName);
        checkoutPage.clickApplyCouponButton();
    }
    @Step
    public void verifySuccessAddCouponMessage(){checkoutPage.verifySuccessAddCouponMessage();}

    @Step
    public void addProductsToCart(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectProductFromShopList("Long Sleeve Tee");
        productPage.clickAddToCartButton();
        homePage.clickShop();
        shopPage.selectProductFromShopList("Polo");
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
    }

    @Step
    public void clickRemoveCouponButton(){checkoutPage.clickRemoveCoupon();}

    @Step
    public void checkCartSubtotalIsCorrect(){Assert.assertTrue(checkoutPage.isSubtotalPriceCalculatedCorrectly());
    }

    @Step
    public void checkCartGrandTotalIsCorrect(){
        Assert.assertTrue(checkoutPage.isGrandTotalPriceCorrect());
    }

    @Step
    public void verifySuccessRemoveCouponMessage(){checkoutPage.verifySuccessRemoveCouponMessage();}
}
