package org.fasttrackit.features.search;

import org.fasttrackit.pages.HomePage;
import org.junit.Test;

public class HomePageTest extends BaseTest{


    @Test
    public void verifyWelcomeHomePageMessage(){
        homePageSteps.navigateToHomepage();
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
