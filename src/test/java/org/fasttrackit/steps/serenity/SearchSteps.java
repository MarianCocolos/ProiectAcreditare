package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps extends ScenarioSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;

    @Step
    public void doSearch(String keyword){
        homePage.setSearchField(keyword);
        homePage.clickSearchIcon();
    }
    @Step
    public void verifyProductInResults(String productName){
        Assert.assertTrue(searchResultsPage.checkListForProduct(productName));
    }
    @Step
    public void verifySearchResultsText(String text){searchResultsPage.verifySearchResultsText(text);}
    @Step
    public void verifyProductResultsMessage(String text){searchResultsPage.verifyProductResultsMessage(text);}
    @Step
    public void verifySuccessSearchProduct(String text){productPage.verifySuccessSearchProduct(text);}
}
