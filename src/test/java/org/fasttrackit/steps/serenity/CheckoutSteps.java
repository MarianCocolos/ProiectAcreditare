package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.CheckoutPage;
import org.fasttrackit.pages.HomePage;

public class CheckoutSteps extends ScenarioSteps {

    private CheckoutPage checkoutPage;
    private HomePage homePage;

    @Step
    public void verifyCheckoutPageTitle(){
        homePage.open();
        homePage.clickCheckout();
        checkoutPage.verifyCheckoutPageTitle();
    }
    @Step
    public void verifyProceedToCheckoutSuccess(){checkoutPage.verifyCheckoutPageTitle();}
}
