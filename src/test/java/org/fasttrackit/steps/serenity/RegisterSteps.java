package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;

public class RegisterSteps extends ScenarioSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;


    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToMyAccountPage(){homePage.clickAccountLink();}

    @Step
    public void setCredentials(String email, String pass) {
        myAccountPage.setRegisterEmailField(email);
        myAccountPage.setRegisterPasswordField(pass);
    }

    @Step
    public void clickRegister(){ myAccountPage.clickRegisterButton();
    }

    @Step
    public void verifyEmailAddressErrorUsed(){
        myAccountPage.verifyEmailAddressErrorUsed();
    }

    @Step
    public void verifyEmailAddressMissingError(){
        myAccountPage.verifyEmailAddressMissingError();
    }

    @Step
    public void verifyRegisterWithoutCredentials(){
        myAccountPage.verifyRegisterWithoutCredentials();
    }

    @Step
    public void doRegister(String email, String password) {
        navigateToHomepage();
        navigateToMyAccountPage();
        setCredentials(email, password);
        clickRegister();
    }
}

