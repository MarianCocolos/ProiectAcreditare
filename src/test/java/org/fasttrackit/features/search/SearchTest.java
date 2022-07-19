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
        searchSteps.verifySearchResultsText();
        searchSteps.verifyProductResultsMessage();
    }

    @Test
    public void searchByAnExistingItem(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("beanie with Logo");
        searchSteps.verifySuccessSearchProduct();
    }

    @Test
    public void searchForANonExistingRandomWord(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("phone");
        searchSteps.verifyProductResultsMessage();
    }
}
