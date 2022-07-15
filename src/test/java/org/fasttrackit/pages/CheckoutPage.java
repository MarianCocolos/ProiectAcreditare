package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class CheckoutPage extends BasePage{

    @FindBy(css = ".current")
    private WebElementFacade checkoutPageTitle;

    public void verifyCheckoutPageTitle(){ checkoutPageTitle.getText().equals("Checkout");
    }
}
