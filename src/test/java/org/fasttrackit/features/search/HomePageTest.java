package org.fasttrackit.features.search;

import org.fasttrackit.pages.HomePage;
import org.junit.Test;

public class HomePageTest extends BaseTest{
    private HomePage homePage;


    @Test
    public void verifyHomePageTitle(){
        homePage.open();
        homePageSteps.verifyHomePageTitle();
    }

    @Test
    public void verifyReadMorePage() {
        homePageSteps.verifyReadMorePage();
    }

    @Test
    public void verifyUncategorizedPageTitle() {
        homePageSteps.verifyUncategorizedPageLink();
    }

    @Test
    public void verifyArchivesPage() {
        homePageSteps.verifyArchivePageLink();
    }

}
