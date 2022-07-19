package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest{


    @Test
    public void registrationOfTheEmailAddressAlreadyUsed(){
        registerSteps.doRegister(Constants.USER_EMAIL,Constants.USER_PASS);
        registerSteps.verifyEmailAddressErrorUsed();
    }

    @Test
    public void registrationWithoutEmailAddress(){
        registerSteps.doRegister("",Constants.USER_PASS);
        registerSteps.verifyEmailAddressMissingError();
    }

    @Test
    public void registrationWithoutCredentials(){
        registerSteps.doRegister("","");
        registerSteps.verifyRegisterWithoutCredentials();
    }

}
