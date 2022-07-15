package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.SearchResultsPage;
import org.fasttrackit.pages.ShopPage;

public class ProductSteps extends ScenarioSteps {

    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private HomePage homePage;
    private ShopPage shopPage;

    @Step
    public void selectProductFromList(String product){
        searchResultsPage.selectProductFromList(product);
    }

    @Step
    public void addToCartProduct() {
        homePage.open();
        homePage.clickShop();
        shopPage.selectPopularity();
        shopPage.selectFirstProductByPopularity();
        productPage.clickAddToCartButton();
    }
    @Step
    public void verifySuccessAddToCartMessage(String productName){productPage.verifySuccessAddToCartMessage(productName);}

    @Step
    public void verifyZoomButton() {
        homePage.open();
        homePage.clickShop();
        searchResultsPage.selectProductFromList("Beanie");
        productPage.clickZoomButton();
    }
    @Step
    public void clickCloseZoomPage() {productPage.clickCloseZoomPage();}

    @Step
    public void clickSubmitButton() { productPage.clickSubmitButton();}

    @Step
    public void writeReview(String text) { productPage.writeReview(text);}

    @Step
    public void setRatingOneStar() { productPage.setRatingOneStar();}
    public void setRatingTwoStars() {productPage.setRatingTwoStars();}
    public void setRatingThreeStars() {  productPage.setRatingThreeStars();}
    public void setRatingFourStars() { productPage.setRatingFourStars();}
    public void setRatingFiveStars() { productPage.setRatingFiveStars();}

    @Step
    public void clickReviewsCategory() { productPage.clickReviewsCategory();}

    @Step
    public void verifyAwaitingApprovalReviewMessage() { productPage.verifyAwaitingApprovalReviewMessage();}

}

