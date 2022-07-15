package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCart() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("beanie");
        productSteps.selectProductFromList("Beanie");
        cartSteps.clickAddToCart();
        cartSteps.verifySuccessMessage("Beanie");
    }

    @Test
    public void verifyPricesTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        cartSteps.addProductsToCart();
        cartSteps.checkCartSubtotalIsCorrect();
        cartSteps.checkCartGrandTotalIsCorrect();
    }
    @Test
    public void removeProductToCart() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        cartSteps.clickAddToCart();
        cartSteps.clickViewCartButton();
        cartSteps.clickRemoveCartButton();
        cartSteps.verifySuccessMessageRemoveProduct("Beanie with Logo");
    }
    @Test
    public void verifyProceedToCheckoutButton(){
        cartSteps.verifyProceedToCheckoutButton();
        checkoutSteps.verifyProceedToCheckoutSuccess();
    }
}