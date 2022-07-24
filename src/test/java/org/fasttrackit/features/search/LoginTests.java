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
        loginSteps.verifyInvalidUsernameMessage("ERROR: Invalid username. Lost your password?");
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginSteps.doLogin(Constants.USER_EMAIL,"1234567");
        loginSteps.verifyIncorrectPasswordMessage("ERROR: The password you entered for the email address cmarianc23@yahoo.com is incorrect. Lost your password?");
    }

    @Test
    public void loginWithoutCredentials() {
        loginSteps.doLogin("","");
        loginSteps.verifyLoginWithoutCredentialsMessage("Error: Username is required.");
    }
}
