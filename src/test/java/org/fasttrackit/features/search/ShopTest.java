package org.fasttrackit.features.search;

import org.junit.Test;

public class ShopTest extends BaseTest{

    @Test
    public void verifyShopPageTitle(){
        shopSteps.verifyShopPageTitle("SHOP");}

    @Test
    public void orderProductsAllOptions(){
        shopSteps.orderProductsAllOptions();}

    @Test
    public void selectProductFromShopList(){
        homePageSteps.navigateToHomepage();
        homePageSteps.navigateToShop();
        shopSteps.selectProductFromShopList("Hoodie with Zipper");
        shopSteps.verifyProductNameSelected("Hoodie with Zipper");
    }

    @Test
    public void addToCartProduct() {
       shopSteps.addProductToCart("Album");
       shopSteps.verifyIfProductAddedToCart("Album");
    }
}
