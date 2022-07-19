package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".entry-title")
    private WebElementFacade cartPageTitle;

    @FindBy(css = ".button.wc-backward")
    private WebElementFacade returnToShopButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successMessage;

    @FindBy(css = ".product-subtotal .woocommerce-Price-amount")
    private List<WebElementFacade> listOfProductsSubTotalSpan;

    @FindBy(css = ".cart-subtotal .woocommerce-Price-amount")
    private WebElementFacade cartSubtotalPriceSpan;

    @FindBy(css = "0")
    private WebElementFacade cartShippingFeeSpan;

    @FindBy(css = ".order-total .woocommerce-Price-amount")
    private WebElementFacade cartGrandTotalPrice;

    @FindBy(css = ".remove")
    private WebElementFacade removeCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successMessageRemoveProduct;

    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    private WebElementFacade proceedToCheckoutButton;

    public void verifyCartPageTitle(String textFromElement){ cartPageTitle.getText();
        Assert.assertEquals("Cart",textFromElement);
    }

    public void verifyReturnToShopButton() {returnToShopButton.click();}

    public void clickRemoveCartButton(){
        clickOn(removeCartButton);
    }

    public void verifySuccessMessageAddProduct(String productName,String text){successMessage.getText();
        Assert.assertEquals("“"+productName+"“has been added to your cart.","“"+productName+"“" + text);
    }

    public void verifySuccessMessageRemoveProduct(String productName,String text){successMessageRemoveProduct.getText();
        Assert.assertEquals("“"+productName+"“removed.","“"+productName+"“" + text);
    }

    public void clickProceedToCheckoutButton() { clickOn(proceedToCheckoutButton);}

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

    public int getSubtotalPriceWithTaxes(){
        String x = cartSubtotalPriceSpan.getText();
        String y = "0";
        if (cartShippingFeeSpan.isPresent()){
            y = cartShippingFeeSpan.getText();
        }
        return getPriceFromString(x) + getPriceFromString(y);
   }

    public boolean isGrandTotalPriceCorrect() {
        return getSubtotalPriceWithTaxes() == getPriceFromString(cartGrandTotalPrice.getText());

    }

}
