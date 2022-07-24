package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.MyAccountPage;
import org.fasttrackit.pages.ShopPage;

public class MyAccountSteps extends ScenarioSteps {

    private MyAccountPage myAccountPage;
    private ShopPage shopPage;

    @Step
    public void clickOnOrdersButton(){myAccountPage.clickOnOrders();}
    @Step
    public void clickOnViewOrder(){myAccountPage.clickOnViewOrder();}
    @Step
    public void verifyOrderStatusMessage(){myAccountPage.verifyOrderStatus();}
    @Step
    public void clickGoShopButtonFromDownloads(){myAccountPage.clickGoShopButton();}
    @Step
    public void clickOnDownloadsButton(){myAccountPage.clickOnDownloadsButton();}
    @Step
    public void verifyShopPage(){shopPage.verifyShopPageTitle("SHOP");}
    @Step
    public void clickOnAccountDetailsButton(){myAccountPage.clickOnAccountDetailsButton();}
    @Step
    public void clickOnSaveChanges(){myAccountPage.clickOnSaveChanges();}
    @Step
    public void verifyChangedSuccessfullyMessage(){myAccountPage.verifyChangedSuccessfullyMessage("Account details changed successfully.");}
    @Step
    public void completePasswordChangeFields(){
        myAccountPage.setFirstName("Marian");
        myAccountPage.setLastName("Cocolos");
        myAccountPage.setEmailAddress("cmarianc23@yahoo.com");
        myAccountPage.setCurrentPassword("cmarianc23@");
        myAccountPage.setNewPassword("cmarianc23@");
        myAccountPage.setConfirmNewPassword("cmarianc23@");
    }
    @Step
    public void clickOnLogoutButton(){myAccountPage.clickOnLogoutButton();}
    @Step
    public void verifyLoginPageMessage(){myAccountPage.verifyLoginPageMessage("Login");}
}
