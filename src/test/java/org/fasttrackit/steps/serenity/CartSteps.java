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
    private ShopPage shopPage;

    @Step
    public void verifyCartPageTitle(String text){
        homePage.open();
        homePage.clickCart();
        cartPage.verifyCartPageTitle(text);}

    @Step
    public void verifyReturnToShopButton(String text) {
        homePage.open();
        homePage.clickCart();
        cartPage.verifyReturnToShopButton();
        shopPage.verifyShopPageTitle(text);
    }

    @Step
    public void clickAddToCart(){
        productPage.clickAddToCartButton();
    }

    @Step
    public void clickProceedToCheckoutButton(){cartPage.clickProceedToCheckoutButton();}

    @Step
    public void clickViewCartButton(){productPage.clickViewCartButton();}

    @Step
    public void clickRemoveCartButton(){cartPage.clickRemoveCartButton();}

    @Step
    public void verifySuccessMessageAddProduct(String productName,String text){
        cartPage.verifySuccessMessageAddProduct(productName,text);
    }

    @Step
    public void verifySuccessMessageRemoveProduct(String productName,String text) {
        cartPage.verifySuccessMessageRemoveProduct(productName,text);}

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
        shopPage.selectProductFromShopList("Belt");
        productPage.clickAddToCartButton();
        homePage.clickShop();
        shopPage.selectProductFromShopList("Cap");
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
    }

    @Step
    public void verifyProceedToCheckoutButton(String product){
        homePage.open();
        homePage.clickShop();
        shopPage.selectProductFromShopList(product);
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
        cartPage.clickProceedToCheckoutButton();
    }
}