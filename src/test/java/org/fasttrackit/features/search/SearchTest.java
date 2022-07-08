package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest{

    private String searchItem = "Beanie";

    @Test
    public void searchProductTest(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch(searchItem);
        searchSteps.verifyProductInResults("Beanie with Logo");
    }

    @Test
    public void searchAnotherProductTest(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch(searchItem);
        searchSteps.verifyProductInResults("Beanie");
    }
}
