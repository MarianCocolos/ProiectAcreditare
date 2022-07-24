package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.Dropdown;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".button.wc-forward")
    private WebElementFacade viewCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successAddToCartMessage;
    @FindBy(css = ".woocommerce-product-gallery__trigger")
    private WebElementFacade zoomButton;
    @FindBy(css = ".pswp__button--close")
    private WebElementFacade closeZoomPageButton;
    @FindBy(css = ".reviews_tab.active")
    private WebElementFacade reviewsPage;
    @FindBy(css = ".submit")
    private WebElementFacade submitButton;
    @FindBy(css = "#comment")
    private WebElementFacade reviewField;
    @FindBy(css = ".woocommerce-review__awaiting-approval")
    private WebElementFacade awaitingApprovalReviewMessage;
    @FindBy(css = ".star-1")
    private WebElementFacade oneStar;
    @FindBy(css = ".star-2")
    private WebElementFacade twoStar;
    @FindBy(css = ".star-3")
    private WebElementFacade threeStar;
    @FindBy(css = ".star-4")
    private WebElementFacade fourStar;
    @FindBy(css = ".star-5")
    private WebElementFacade fiveStar;
    @FindBy(css = ".reviews_tab")
    private WebElementFacade reviewsCategory;
    @FindBy(css = ".product_title")
    private WebElementFacade nameOfProduct;
    @FindBy(css = ".posted_in a")
    private WebElementFacade accessoriesLink;
    @FindBy(css = ".entry-title")
    private WebElementFacade accessoriesTitlePage;


    public void clickAddToCartButton(){clickOn(addToCartButton);}

    public void clickViewCartButton(){clickOn(viewCartButton);}

    public void verifySuccessAddToCartMessage(String productName,String text){successAddToCartMessage.getText();
        Assert.assertEquals("“"+productName+"“has been added to your cart.","“"+productName+"“" + text);
    }
    public void clickZoomButton() { clickOn(zoomButton); }

    public void clickCloseZoomPage() { clickOn(closeZoomPageButton);}

    public void writeReview(String text) {
        typeInto(reviewField, text);
    }

    public void clickSubmitButton() { submitButton.click();}

    public void verifyAwaitingApprovalReviewMessage(String textFromElement) {awaitingApprovalReviewMessage.getText();
        Assert.assertEquals("Your review is awaiting approval",textFromElement);
    }

    public void setRatingOneStar() {oneStar.click();}
    public void setRatingTwoStars() {twoStar.click();}
    public void setRatingThreeStars() { threeStar.click();}
    public void setRatingFourStars() { fourStar.click();}
    public void setRatingFiveStars() { fiveStar.click();}
    public void clickReviewsCategory() { reviewsCategory.click();}

    public void verifySuccessSearchProduct(String textFromElement){nameOfProduct.getText();
        Assert.assertEquals("Beanie with Logo",textFromElement);}

    public void clickAccessoriesLink(){accessoriesLink.click();}
    public void verifyAccessoriesPageTitle(String textFromElement){accessoriesTitlePage.getText();
    Assert.assertEquals("ACCESSORIES",textFromElement);}
}
