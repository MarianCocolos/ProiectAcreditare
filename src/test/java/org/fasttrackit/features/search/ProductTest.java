package org.fasttrackit.features.search;

import net.thucydides.core.annotations.findby.By;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class ProductTest extends BaseTest{

    @Test
    public void verifyAddToCartButton(){
       productSteps.addToCartProduct();
       productSteps.verifySuccessAddToCartMessage("Album");
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
        productSteps.clickReviewsCategory();
        productSteps.setRatingFiveStars();
        productSteps.writeReview("Good product!");
        productSteps.clickSubmitButton();
        productSteps.verifyAwaitingApprovalReviewMessage();
    }

}
