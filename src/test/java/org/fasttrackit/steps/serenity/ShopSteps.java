package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ShopPage;

public class ShopSteps extends ScenarioSteps {
    private ShopPage shopPage;
    private HomePage homePage;

    @Step
    public void verifyShopPageTitle(){
        homePage.open();
        homePage.clickShop();
        shopPage.verifyShopPageTitle();
    }

    @Step
    public void orderProductsAllOptions(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectNewness();
        waitABit(300);
        shopPage.selectLowToHigh();
        waitABit(300);
        shopPage.selectByAverageRating();
        waitABit(300);
        shopPage.selectPopularity();
        waitABit(300);
        shopPage.selectHighToLow();
    }

    @Step
    public void selectFirstProductByPopularity(){
        homePage.open();
        homePage.clickShop();
        shopPage.selectPopularity();
        shopPage.selectFirstProductByPopularity();
    }

}

