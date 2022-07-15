package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    @FindBy(id = "username")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(css = ".woocommerce-Button.button")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade emailAddressErrorUsed;

    @FindBy(css = ".woocommerce-error li strong")
    private WebElementFacade emailAddressMissingError;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade loginWithoutCredentials;

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailField;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPasswordField;

    @FindBy(css = "p.woocommerce-FormRow.form-row > button")
    private WebElementFacade registerButton;

    @FindBy(css = "strong:nth-child(1)")
    private WebElementFacade welcomeText;

    @FindBy(css = ".woocommerce-error li strong")
    private WebElementFacade registerWithoutCredentials;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade invalidUsername;

    @FindBy(css = ".woocommerce li")
    private WebElementFacade incorrectPassword;


    public void setRegisterEmailField(String registerEmail){typeInto(registerEmailField, registerEmail);}

    public void setRegisterPasswordField(String registerPassword) {
        waitFor(registerPasswordField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(registerPasswordField);
        typeInto(registerPasswordField, registerPassword);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        waitFor(passwordField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(passwordField);
        typeInto(passwordField, password);
    }


    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void verifyWelcomeMessage(String userName){
        welcomeText.getText().equals("cmarianc23");
    }

    public void verifyEmailAddressErrorUsed(){
        emailAddressErrorUsed.getText().equals("Error: An account is already registered with your email address. Please log in.");
    }

    public void verifyLoginWithoutCredentialsMessage() {
        loginWithoutCredentials.getText().equals("Error: Username is required.");
    }

    public void verifyEmailAddressMissingError(){
        emailAddressMissingError.getText().equals("Error: Please provide a valid email address.");
    }

    public void verifyRegisterWithoutCredentials(){
        registerWithoutCredentials.getText().equals("Error: Please provide a valid email address.");
    }

    public void verifyInvalidUsernameMessage(){
        invalidUsername.getText().equals("ERROR: Invalid username. Lost your password?");
    }

    public void verifyErrorIncorrectPassword(){
        incorrectPassword.getText().equals("ERROR: The password you entered for the email address cmarianc23@yahoo.com is incorrect. Lost your password?");
    }
}
