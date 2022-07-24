package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest{

     private String searchItem = "beanie";

    @Test
    public void searchProductTest(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("beanie");
        searchSteps.verifyProductInResults("Beanie with Logo");
    }

    @Test
    public void verifySearchTextBoxCharacterAcceptance(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("123@%&*(");
        searchSteps.verifySearchResultsText("SEARCH RESULTS: “123@%&*(”");
        searchSteps.verifyProductResultsMessage("No products were found matching your selection.");
    }

    @Test
    public void searchByAnExistingItem(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("beanie with Logo");
        searchSteps.verifySuccessSearchProduct("Beanie with Logo");
    }

    @Test
    public void searchForANonExistingRandomWord(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("phone");
        searchSteps.verifyProductResultsMessage("No products were found matching your selection.");
    }
}
