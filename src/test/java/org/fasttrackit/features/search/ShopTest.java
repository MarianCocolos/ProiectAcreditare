package org.fasttrackit.features.search;

import org.junit.Test;

public class ShopTest extends BaseTest{

    @Test
    public void verifyShopPageTitle(){
        shopSteps.verifyShopPageTitle();}

    @Test
    public void orderProductsAllOptions(){
        shopSteps.orderProductsAllOptions();}

    @Test
    public void selectFirstProductByPopularity(){
        shopSteps.selectFirstProductByPopularity();}

}
