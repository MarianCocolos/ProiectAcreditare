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
    public void verifySuccessAddCouponMessage(String text){checkoutPage.verifySuccessAddCouponMessage(text);}

    @Step
    public void addProductsToCart(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectProductFromShopList("Album");
        productPage.clickAddToCartButton();
        homePage.clickShop();
        shopPage.selectProductFromShopList("Belt");
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
    public void verifySuccessRemoveCouponMessage(String text){checkoutPage.verifySuccessRemoveCouponMessage(text);}

    @Step
    public void addProductToCart(String product){
        homePage.clickShop();
        shopPage.selectProductFromShopList(product);
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
    }

    @Step
    public void completeBillingDetails(){
        checkoutPage.setFirstName("Marian");
        checkoutPage.setLastName("Cocolos");
        checkoutPage.completeCompanyName("MC SRL");
        checkoutPage.selectCountry("Romania");
        checkoutPage.completeStreetAddress("Metalurgie,nr4");
        checkoutPage.completeApartmentAddress("Bloc 4,ap 23");
        checkoutPage.completeTownCity("Cluj");
        checkoutPage.setCountyName("Cluj");
        checkoutPage.completePostcode("700293");
        checkoutPage.completePhoneNumber("0747888679");
        checkoutPage.setEmailAddress("cmarianc23@yahoo.com");
    }
    @Step
    public void placeOrder(){checkoutPage.clickPlaceOrder();}

    @Step
    public void verifyOrderConfirmation(String text){checkoutPage.verifyOrderMessage(text);}
    @Step
    public void verifyMissingPhoneMessage(String text){checkoutPage.missingPhoneMessage(text);}
    @Step
    public void completeBillingDetailsWithoutPhoneNumber(){
        checkoutPage.setFirstName("Marian");
        checkoutPage.setLastName("Cocolos");
        checkoutPage.completeCompanyName("MC SRL");
        checkoutPage.selectCountry("Romania");
        checkoutPage.completeStreetAddress("Metalurgie,nr4");
        checkoutPage.completeApartmentAddress("Bloc 4,ap 23");
        checkoutPage.completeTownCity("Cluj");
        checkoutPage.setCountyName("Cluj");
        checkoutPage.completePostcode("700293");
        checkoutPage.completePhoneNumber("");
        checkoutPage.setEmailAddress("cmarianc23@yahoo.com");
    }
}
