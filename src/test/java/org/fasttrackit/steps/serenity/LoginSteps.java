package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToLogin() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
    }

    @Step
    public void setCredentials(String email, String pass) {
       myAccountPage.setEmailField(email);
       myAccountPage.setPasswordField(pass);
    }

    @Step
    public void clickLogin() {
        myAccountPage.clickLoginButton();
    }

    @Step
    public void verifyUsernameMessage(String userName) {
        myAccountPage.verifyWelcomeMessage(userName);
    }

    @Step
    public void doLogin(String email, String password) {
        navigateToHomepage();
        navigateToLogin();
        setCredentials(email, password);
        clickLogin();
    }

    @Step
    public void verifyInvalidUsernameMessage(){
        myAccountPage.verifyInvalidUsernameMessage();
    }

    @Step
    public void verifyIncorrectPasswordMessage() {myAccountPage.verifyErrorIncorrectPassword();}
}
