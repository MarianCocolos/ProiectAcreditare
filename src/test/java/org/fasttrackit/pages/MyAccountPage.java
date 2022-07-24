package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

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
    @FindBy(css = "p:nth-child(1)")
    private WebElementFacade welcomeText;
    @FindBy(css = ".woocommerce-error li strong")
    private WebElementFacade registerWithoutCredentials;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade invalidUsername;
    @FindBy(css = ".woocommerce li")
    private WebElementFacade incorrectPassword;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--orders a")
    private WebElementFacade ordersButton;
    @FindBy(css = "tr:nth-child(1) .woocommerce-orders-table__cell-order-actions .view")
    private WebElementFacade viewOrdersButton;
    @FindBy(css = "#post-7 > div > div > div > div > div > p")
    private WebElementFacade orderStatusMessage;
    @FindBy(css = ".woocommerce-info .button ")
    private WebElementFacade goShopButton;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--downloads")
    private WebElementFacade downloadsButton;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-account")
    private WebElementFacade accountDetailsButton;
    @FindBy(id = "account_first_name")
    private WebElementFacade firstNameFieldPasswordChange;
    @FindBy(id = "account_last_name")
    private WebElementFacade lastNameFieldPasswordChange;
    @FindBy(id = "account_email")
    private WebElementFacade emailAddressFieldPasswordChange;
    @FindBy(id = "password_current")
    private WebElementFacade currentPassword;
    @FindBy(id = "password_1")
    private WebElementFacade newPassword;
    @FindBy(id = "password_2")
    private WebElementFacade confirmNewPassword;
    @FindBy(css = ".button")
    private WebElementFacade saveChangesButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade changedSuccessfullyMessage;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElementFacade logoutButton;
    @FindBy(css = ".col-1 h2")
    private WebElementFacade loginPageMessage;

    public void setRegisterEmailField(String registerEmail){typeInto(registerEmailField, registerEmail);}

    public void setRegisterPasswordField(String registerPassword) {
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(registerPasswordField);
        typeInto(registerPasswordField, registerPassword);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }

    public void setEmailField(String email) {typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }


    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void verifyWelcomeMessage(String userName){
        welcomeText.shouldContainOnlyText("Hello "+userName+" (not "+userName+"? Log out)");
    }

    public void verifyEmailAddressErrorUsed(String textFromElement){emailAddressErrorUsed.getText();
        Assert.assertEquals("Error: An account is already registered with your email address. Please log in.",textFromElement);
    }

    public void verifyLoginWithoutCredentialsMessage(String textFromElement) {loginWithoutCredentials.getText();
        Assert.assertEquals("Error: Username is required.",textFromElement);
    }

    public void verifyEmailAddressMissingError(String textFromElement){emailAddressMissingError.getText();
        Assert.assertEquals("Error: Please provide a valid email address.",textFromElement);
    }

    public void verifyRegisterWithoutCredentials(String textFromElement){registerWithoutCredentials.getText();
        Assert.assertEquals("Error: Please provide a valid email address.",textFromElement);
    }

    public void verifyInvalidUsernameMessage(String textFromElement){invalidUsername.getText();
        Assert.assertEquals("ERROR: Invalid username. Lost your password?",textFromElement);
    }

    public void verifyErrorIncorrectPassword(String textFromElement){incorrectPassword.getText();
        Assert.assertEquals("ERROR: The password you entered for the email address cmarianc23@yahoo.com is incorrect. Lost your password?",textFromElement);
    }

    public void clickOnOrders(){clickOn(ordersButton);}
    public void clickOnViewOrder(){viewOrdersButton.click();}
    public void verifyOrderStatus(){orderStatusMessage.getText().equals("Processing.");}
    public void clickGoShopButton(){clickOn(goShopButton);}
    public void clickOnDownloadsButton(){downloadsButton.click();}
    public void clickOnAccountDetailsButton(){accountDetailsButton.click();}
    public void setFirstName(String firstName){typeInto(firstNameFieldPasswordChange,firstName);}
    public void setLastName(String lastName){typeInto(lastNameFieldPasswordChange,lastName);}
    public void setEmailAddress(String emailAddress){typeInto(emailAddressFieldPasswordChange,emailAddress);}
    public void setCurrentPassword(String password) {
        typeInto(currentPassword, password);
    }
    public void setNewPassword(String password) {typeInto(newPassword, password);}
    public void setConfirmNewPassword(String password) {
        typeInto(confirmNewPassword, password);
    }
    public void clickOnSaveChanges(){saveChangesButton.click();}
    public void verifyChangedSuccessfullyMessage(String textFromElement){changedSuccessfullyMessage.getText();
    Assert.assertEquals("Account details changed successfully.",textFromElement);}
    public void clickOnLogoutButton(){logoutButton.click();}
    public void verifyLoginPageMessage(String textFromElement){loginPageMessage.getText();
    Assert.assertEquals("Login",textFromElement);}

}
