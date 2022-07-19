package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.*;

public class ShopSteps extends ScenarioSteps {
    private ShopPage shopPage;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;
    private ProductPage productPage;

    @Step
    public void verifyShopPageTitle(String text){
        homePage.open();
        homePage.clickShop();
        shopPage.verifyShopPageTitle(text);
    }

    @Step
    public void orderProductsAllOptions(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectNewness();
        waitABit(400);
        shopPage.selectLowToHigh();
        waitABit(400);
        shopPage.selectByAverageRating();
        waitABit(400);
        shopPage.selectPopularity();
        waitABit(400);
        shopPage.selectHighToLow();
    }

    @Step
    public void selectProductFromShopList(String product){shopPage.selectProductFromShopList(product);}
    @Step
    public void addProductToCart(String product){
        homePage.open();
        homePage.clickShop();
        shopPage.selectProductFromShopList(product);
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();
    }

    @Step
    public void selectProduct(String product){
        homePage.open();
        homePage.clickShop();
        shopPage.selectProductFromShopList(product);
    }

    @Step
    public void selectFirstProductByPopularity(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectPopularity();
        shopPage.selectFirstProductByPopularity();
    }

}

