package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;
import org.openqa.selenium.By;

public class CartTest extends BaseTest {
    @Test
    public void verifyCartPageTitle() { cartSteps.verifyCartPageTitle("Cart");}

    @Test
    public void verifyReturnToShopButton() { cartSteps.verifyReturnToShopButton("SHOP");}

    @Test
    public void addProductToCart() {
        shopSteps.selectProduct("belt");
        productSteps.clickAddToCartButton();
        cartSteps.verifySuccessMessageAddProduct("","has been added to your cart.");
    }

    @Test
    public void verifyPricesTest() {
        cartSteps.addProductsToCart();
        cartSteps.checkCartSubtotalIsCorrect();
        cartSteps.checkCartGrandTotalIsCorrect();
    }
    @Test
    public void removeProductToCart() {
        shopSteps.addProductToCart("beanie with logo");
        cartSteps.clickRemoveCartButton();
        cartSteps.verifySuccessMessageRemoveProduct("Beanie with Logo","removed.");
    }
    @Test
    public void verifyProceedToCheckoutButton(){
        cartSteps.verifyProceedToCheckoutButton();
        checkoutSteps.verifyProceedToCheckoutSuccess("Checkout");
    }

}