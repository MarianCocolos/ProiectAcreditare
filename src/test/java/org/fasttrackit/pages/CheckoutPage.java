package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;


public class CheckoutPage extends BasePage{

    @FindBy(css = ".current")
    private WebElementFacade checkoutPageTitle;
    @FindBy(css = ".showcoupon")
    private WebElementFacade haveACuponLink;
    @FindBy(css = "#coupon_code.input-text")
    private WebElementFacade couponField;
    @FindBy(css = ".form-row-last .button")
    private WebElementFacade applyCouponButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successAddCouponMessage;
    @FindBy(css = ".woocommerce-remove-coupon")
    private WebElementFacade removeCouponButton;
    @FindBy(css = ".product-total .amount")
    private List<WebElementFacade> listOfProductsSubTotalSpan2;
    @FindBy(css = ".cart-subtotal .amount")
    private WebElementFacade checkoutSubtotalPriceSpan;
    @FindBy(css = ".cart-discount .amount")
    private WebElementFacade checkoutDiscountSpan;
    @FindBy(css = ".order-total .amount")
    private WebElementFacade checkoutGrandTotalPrice;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successRemoveCouponMessage;

    public void verifyCheckoutPageTitle(String textFromElement) {checkoutPageTitle.getText();
        Assert.assertEquals("Checkout",textFromElement);
    }

    public void clickOnCuponLink(){haveACuponLink.click();}
    public void clickApplyCouponButton(){clickOn(applyCouponButton);}
    public void completeCouponField(String couponName){typeInto(couponField,couponName);}
    public void verifySuccessAddCouponMessage(){successAddCouponMessage.getText().equals("Coupon code applied successfully.");}

    public void clickRemoveCoupon(){removeCouponButton.click();}
    public void verifySuccessRemoveCouponMessage(){successRemoveCouponMessage.getText().equals("Coupon has been removed.");}

    public int getSubtotalPriceFromProducts() {
        int sum = 0;
        for (WebElementFacade element : listOfProductsSubTotalSpan2) {
            sum += getPriceFromString(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCalculatedCorrectly() {
        int actual = getPriceFromString(checkoutSubtotalPriceSpan.getText());
        int expected = getSubtotalPriceFromProducts();
        return actual == expected;
    }

    public int getSubtotalPriceWithDiscount(){
        String x = checkoutSubtotalPriceSpan.getText();
        String y = "0";
        if (checkoutDiscountSpan.isPresent()){
            y = checkoutDiscountSpan.getText();
        }
        return getPriceFromString(x) - getPriceFromString(y);
    }

    public boolean isGrandTotalPriceCorrect() {
        return getSubtotalPriceWithDiscount() == getPriceFromString(checkoutGrandTotalPrice.getText());
    }

}
