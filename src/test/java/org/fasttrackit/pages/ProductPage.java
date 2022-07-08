package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".added_to_cart")
    private WebElementFacade viewCartButton;

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }

    public void clickViewCartButton(){clickOn(viewCartButton);}
}
