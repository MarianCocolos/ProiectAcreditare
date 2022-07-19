package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.DeleteSession;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends BasePage{

    @FindBy(css = "#menu-item-70")
    private WebElementFacade accountLink;

    @FindBy(css = ".account")
    private WebElementFacade loginLink;

    @FindBy(css = ".search-field")
    private WebElementFacade searchField;

    @FindBy(css = ".fa.fa-search")
    private WebElementFacade searchIcon;

    @FindBy(css = "#post-1 > div > div > header > h2 > a")
    private WebElementFacade welcomeHomePageMessage;

    @FindBy(css = "#menu-item-71")
    private WebElementFacade checkoutButton;

    @FindBy(css = "#menu-item-72")
    private WebElementFacade cartButton;

    @FindBy(css = "#menu-item-73")
    private WebElementFacade shopButton;

    @FindBy(css = ".bttn")
    private WebElementFacade readMoreButton;

    @FindBy(css = ".entry-title")
    private WebElementFacade readMorePageTitle;

    @FindBy(css = "#archives-2 ul li a")
    private WebElementFacade archiveLink;

    @FindBy(css = ".page-header h2")
    private WebElementFacade archivePageTitle;

    @FindBy(css = ".cat-item a")
    private WebElementFacade uncategorizedLink;

    @FindBy(css = ".page-header h2")
    private WebElementFacade uncategorizedPageTitle;


    public void clickAccountLink() {
        clickOn(accountLink);
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void setSearchField(String keyword) {
        typeInto(searchField, keyword);
    }

    public void clickSearchIcon() {
        waitFor(searchField);
        clickOn(searchIcon);
    }

    public void verifyWelcomeHomePageMessage(String textFromElement){welcomeHomePageMessage.getText();
    Assert.assertEquals("Hello world!",textFromElement);}

    public void clickCheckout(){
        checkoutButton.click();
    }

    public void clickCart(){
        clickOn(cartButton);
    }

    public void clickSearch() { clickOn(searchField);}

    public void clickShop(){
        clickOn(shopButton);
    }

    public void clickReadMoreButton(){readMoreButton.click();}

    public void verifyReadMore(String textFromElement){readMorePageTitle.getText();
        Assert.assertEquals("Hello world!",textFromElement); }

    public void clickUncategorizedLink(){uncategorizedLink.click();}

    public void verifyUncategorizedPageTitle(String textFromElement){uncategorizedPageTitle.getText();
    Assert.assertEquals("Category: Uncategorized",textFromElement);}

    public void verifyArchiveLink(){archiveLink.click();}

    public void verifyArchivePageTitle(String textFromElement){archivePageTitle.getText();
    Assert.assertEquals("Month: April 2018",textFromElement);}



}
