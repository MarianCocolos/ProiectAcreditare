package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest{


    @Test
    public void registrationOfTheEmailAddressAlreadyUsed(){
        registerSteps.doRegister(Constants.USER_EMAIL,Constants.USER_PASS);
        registerSteps.verifyEmailAddressErrorUsed("Error: An account is already registered with your email address. Please log in.");
    }

    @Test
    public void registrationWithoutEmailAddress(){
        registerSteps.doRegister("",Constants.USER_PASS);
        registerSteps.verifyEmailAddressMissingError("Error: Please provide a valid email address.");
    }

    @Test
    public void registrationWithoutCredentials(){
        registerSteps.doRegister("","");
        registerSteps.verifyRegisterWithoutCredentials("Error: Please provide a valid email address.");
    }

}
