package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class MyAccountTest extends BaseTest{


    @Test
    public void verifyStatusOrder(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        myAccountSteps.clickOnOrdersButton();
        myAccountSteps.clickOnViewOrder();
        myAccountSteps.verifyOrderStatusMessage();
    }
    @Test
    public void verifyGoShopButtonFromDownloads(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        myAccountSteps.clickOnDownloadsButton();
        myAccountSteps.clickGoShopButtonFromDownloads();
        myAccountSteps.verifyShopPage();
    }
    @Test
    public void verifyChangePasswordTest(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        myAccountSteps.clickOnAccountDetailsButton();
        myAccountSteps.completePasswordChangeFields();
        myAccountSteps.clickOnSaveChanges();
        myAccountSteps.verifyChangedSuccessfullyMessage();
    }
    @Test
    public void verifyLogoutButton(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        myAccountSteps.clickOnLogoutButton();
        myAccountSteps.verifyLoginPageMessage();
    }

}
