package org.fasttrackit.features.search;

import net.thucydides.core.annotations.findby.By;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class ProductTest extends BaseTest{

    @Test
    public void verifyAddToCartButton(){
       productSteps.addToCartProduct();
       productSteps.verifySuccessAddToCartMessage("Album","has been added to your cart.");
    }

    @Test
    public void verifyZoomButton() {
        productSteps.verifyZoomButton();
        productSteps.clickCloseZoomPage();
    }

    @Test
    public void writeReviewTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("beanie");
        productSteps.selectProductFromList("Beanie");
        productSteps.writeReviewProduct();
        productSteps.verifyAwaitingApprovalReviewMessage("Your review is awaiting approval");
    }

    @Test
    public void verifyAccessoriesCategory(){
        shopSteps.selectProduct("Cap");
        productSteps.clickOnAccessoriesLink();
        productSteps.verifyAccessoriesPageTitle("ACCESSORIES");
    }
}
