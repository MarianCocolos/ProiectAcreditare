package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.junit.Assert;

public class HomePageSteps extends ScenarioSteps {
    private HomePage homePage;

    @Step
    public void navigateToMyaccount() { homePage.clickAccountLink(); }
    @Step
    public void navigateToLoggIn() { homePage.clickLoginLink(); }
    @Step
    public void navigateToSearch() { homePage.clickSearch(); }
    @Step
    public void navigateToCart() { homePage.clickCart(); }
    @Step
    public void navigateToCheckout() { homePage.clickCheckout(); }
    @Step
    public void navigateToShop() { homePage.clickShop(); }
    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void verifyReadMorePage(String text) {
        homePage.open();
        homePage.clickReadMoreButton();
        homePage.verifyReadMore(text);
    }

    @Step
    public void verifyUncategorizedPageLink() {
        homePage.open();
        homePage.clickUncategorizedLink();
        homePage.verifyUncategorizedPageTitle("Category: Uncategorized");
    }

    @Step
    public void verifyWelcomeHomePageMessage(){ homePage.verifyWelcomeHomePageMessage("Hello world!");
    }

    @Step
    public void verifyArchivePageLink() {
        homePage.open();
        homePage.verifyArchiveLink();
        homePage.verifyArchivePageTitle("Month: April 2018");
    }

}
