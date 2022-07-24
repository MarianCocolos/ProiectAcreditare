package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;


public class CheckoutPage extends BasePage{

    @FindBy(css = ".current")
    private WebElementFacade checkoutPageTitle;
    @FindBy(css = ".showcoupon")
    private WebElementFacade haveACuponLink;
    @FindBy(css = "#coupon_code.input-text")
    private WebElementFacade couponField;
    @FindBy(css = ".form-row-last .button")
    private WebElementFacade applyCouponButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successAddCouponMessage;
    @FindBy(css = ".woocommerce-remove-coupon")
    private WebElementFacade removeCouponButton;
    @FindBy(css = ".product-total .amount")
    private List<WebElementFacade> listOfProductsSubTotalSpan2;
    @FindBy(css = ".cart-subtotal .amount")
    private WebElementFacade checkoutSubtotalPriceSpan;
    @FindBy(css = ".cart-discount .amount")
    private WebElementFacade checkoutDiscountSpan;
    @FindBy(css = ".shipping .amount")
    private WebElementFacade checkoutShippingFeeSpan;
    @FindBy(css = ".order-total .amount")
    private WebElementFacade checkoutGrandTotalPrice;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successRemoveCouponMessage;
    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameField;
    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameField;
    @FindBy(id = "billing_company")
    private WebElementFacade companyNameField;
    @FindBy(id = "billing_country")
    private WebElementFacade selectCountrySpan;
    @FindBy(id = "billing_address_1")
    private WebElementFacade streetAddressField;
    @FindBy(id = "billing_address_2")
    private WebElementFacade apartmentField;
    @FindBy(id = "billing_city")
    private WebElementFacade townCityField;
    @FindBy(id = "billing_state")
    private WebElementFacade countyField;
    @FindBy(id = "billing_postcode")
    private WebElementFacade postcodeField;
    @FindBy(id = "billing_phone")
    private WebElementFacade phoneField;
    @FindBy(id = "billing_email")
    private WebElementFacade emailAddressField;
    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".post-title")
    private WebElementFacade orderMessage;
    @FindBy(css = ".woocommerce-error ")
    private WebElementFacade missingPhoneMessage;


    public void verifyCheckoutPageTitle(String textFromElement) {checkoutPageTitle.getText();
        Assert.assertEquals("Checkout",textFromElement);
    }

    public void clickOnCuponLink(){haveACuponLink.click();}
    public void clickApplyCouponButton(){clickOn(applyCouponButton);}
    public void completeCouponField(String couponName){typeInto(couponField,couponName);}
    public void verifySuccessAddCouponMessage(String textFromElement){successAddCouponMessage.getText();
        Assert.assertEquals("Coupon code applied successfully.",textFromElement);}

    public void clickRemoveCoupon(){removeCouponButton.click();}
    public void verifySuccessRemoveCouponMessage(String textFromElement){successRemoveCouponMessage.getText();
        Assert.assertEquals("Coupon has been removed.",textFromElement);}

    public void setFirstName(String firstName){typeInto(firstNameField,firstName);}
    public void setLastName(String lastName){typeInto(lastNameField,lastName);}
    public void completeCompanyName(String companyName){typeInto(companyNameField,companyName);}
    public void selectCountry(String country){
        selectFromDropdown(selectCountrySpan,country);
        }
    public void completeStreetAddress(String streetAddress){typeInto(streetAddressField,streetAddress);}
    public void completeApartmentAddress(String apartmentAddress){typeInto(apartmentField,apartmentAddress);}
    public void completeTownCity(String townCity){typeInto(townCityField,townCity);}
    public void setCountyName(String countyName){
        selectFromDropdown(countyField,countyName);
    }
    public void completePostcode(String postcodeNumber){typeInto(postcodeField,postcodeNumber);}
    public void completePhoneNumber(String phoneNumber){typeInto(phoneField,phoneNumber);}
    public void setEmailAddress(String emailAddress){typeInto(emailAddressField,emailAddress);}
    public void clickPlaceOrder(){placeOrderButton.click();}

    public void verifyOrderMessage(String textFromElement){orderMessage.getText();
    Assert.assertEquals("ORDER RECEIVED",textFromElement);
    }
    public void missingPhoneMessage(String textFromElement){missingPhoneMessage.getText();
    Assert.assertEquals("Billing Phone is a required field.",textFromElement);}


    public int getSubtotalPriceFromProducts() {
        int sum = 0;
        for (WebElementFacade element : listOfProductsSubTotalSpan2) {
            sum += getPriceFromString(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCalculatedCorrectly() {
        int actual = getPriceFromString(checkoutSubtotalPriceSpan.getText());
        int expected = getSubtotalPriceFromProducts();
        return actual == expected;
    }

    public int getSubtotalPriceWithDiscountAndShipping(){
        String x = checkoutSubtotalPriceSpan.getText();
        String y = "0";
        String z = "0";
        if (checkoutDiscountSpan.isPresent()){
            y = checkoutDiscountSpan.getText();
        }
        if (checkoutShippingFeeSpan.isPresent()){
            z = checkoutShippingFeeSpan.getText();
        }
        return getPriceFromString(x) - getPriceFromString(y) + getPriceFromString(z);
    }

    public boolean isGrandTotalPriceCorrect() {
        return getSubtotalPriceWithDiscountAndShipping() == getPriceFromString(checkoutGrandTotalPrice.getText());
    }


}
