package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.*;
import org.junit.Assert;

public class CartSteps extends ScenarioSteps {

    private ProductPage productPage;
    private CartPage cartPage;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private CheckoutPage checkoutPage;

    @Step
    public void clickAddToCart(){
        productPage.clickAddToCartButton();
    }

    @Step
    public void clickViewCartButton(){productPage.clickViewCartButton();}

    @Step
    public void clickRemoveCartButton(){cartPage.clickRemoveCartButton();}

    @Step
    public void verifySuccessMessage(String productName){
        cartPage.verifySuccessMessage(productName);
    }

    @Step
    public void verifySuccessMessageRemoveProduct(String productName) {cartPage.verifySuccessMessageRemoveProduct(productName);}

    @Step
    public void checkCartSubtotalIsCorrect(){
        Assert.assertTrue(cartPage.isSubtotalPriceCalculatedCorrectly());
    }

    @Step
    public void checkCartGrandTotalIsCorrect(){
        Assert.assertTrue(cartPage.isGrandTotalPriceCorrect());
    }

    @Step
    public void addProductsToCart(){
        homePage.open();
        homePage.clickShop();
        searchResultsPage.selectProductFromList("Beanie");
        productPage.clickAddToCartButton();
        homePage.clickShop();
        searchResultsPage.selectProductFromList("Beanie with Logo");
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
    }

    @Step
    public void verifyProceedToCheckoutButton(){
        homePage.open();
        homePage.clickShop();
        searchResultsPage.selectProductFromList("Beanie");
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
        cartPage.verifyProceedToCheckoutButton();
    }
}