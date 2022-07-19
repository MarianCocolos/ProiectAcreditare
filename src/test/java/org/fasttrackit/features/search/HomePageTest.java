package org.fasttrackit.features.search;

import org.fasttrackit.pages.HomePage;
import org.junit.Test;

public class HomePageTest extends BaseTest{
    private HomePage homePage;


    @Test
    public void verifyWelcomeHomePageMessage(){
        homePage.open();
        homePageSteps.verifyWelcomeHomePageMessage();
    }

    @Test
    public void verifyReadMorePage() {
        homePageSteps.verifyReadMorePage("Hello world!");
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
