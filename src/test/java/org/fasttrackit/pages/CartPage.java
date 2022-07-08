package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successMessage;

    @FindBy(css = ".product-subtotal .woocommerce-Price-amount")
    private List<WebElementFacade> listOfProductsSubTotalSpan;

    @FindBy(css = ".cart_totals")
    private WebElementFacade cartSubtotalPriceSpan;

    @FindBy(css = ".cart_totals")
    private WebElementFacade cartShippingFeeSpan;

    @FindBy(css = ".cart_totals")
    private WebElementFacade cartGrandTotalPriceSpan;

    @FindBy(css = ".remove")
    private WebElementFacade removeCartButton;

    public void clickRemoveCartButton(){
        clickOn(removeCartButton);
    }

    public void verifySuccessMessage(String productName){
        successMessage.getText().equals(productName + " has been added to your cart.");
    }

    public int getSubtotalPriceFromProducts() {
        int sum = 0;
        for (WebElementFacade element : listOfProductsSubTotalSpan) {
            sum += getPriceFromString(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCalculatedCorrectly() {
        int actual = getPriceFromString(cartSubtotalPriceSpan.getText());
        int expected = getSubtotalPriceFromProducts();
        return actual == expected;
    }

    public boolean isGrandTotalPriceCorrect() {
        int subtotal = getPriceFromString(cartSubtotalPriceSpan.getText());
        int fees = getPriceFromString(cartShippingFeeSpan.getText());
        int expected = subtotal + fees;
        int actual = getPriceFromString(cartGrandTotalPriceSpan.getText());
        return expected == actual;

    }


}
