package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;


public class LoginTests extends BaseTest{


    @Test
    public void loginWithValidCredentialsTest(){
        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.verifyUsernameMessage("cmarianc23");
    }

    @Test
    public void loginWithInvalidUsername(){
        loginSteps.doLogin("Adhfsbj",Constants.USER_PASS);
        loginSteps.verifyInvalidUsernameMessage();
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginSteps.doLogin(Constants.USER_EMAIL,"1234567");
        loginSteps.verifyIncorrectPasswordMessage();
    }

    @Test
    public void loginWithoutCredentials() {
        loginSteps.doLogin("","");
        loginSteps.verifyLoginWithoutCredentialsMessage();
    }
}
