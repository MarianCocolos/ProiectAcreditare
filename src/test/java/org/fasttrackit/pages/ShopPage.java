package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class ShopPage extends BasePage{

    @FindBy(css = ".entry-title.ak-container")
    private WebElementFacade shopPageTitle;
    @FindBy(css = "option:nth-child(1)")
    private WebElementFacade selectPopularity;
    @FindBy(css = "option:nth-child(2)")
    private WebElementFacade selectByAverageRating;
    @FindBy(css = "option:nth-child(3)")
    private WebElementFacade selectNewness;
    @FindBy(css = "option:nth-child(4)")
    private WebElementFacade selectLowToHigh;
    @FindBy(css = "option:nth-child(5)")
    private WebElementFacade selectHighToLow;
    @FindBy(css = ".orderby")
    private WebElementFacade selectFromDropdown;
    @FindBy(css = ".collection_title")
    private WebElementFacade firstProductByPopularity;
    @FindBy(css = ".ajax_add_to_cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".wc-forward")
    private WebElementFacade viewCartButton;
    @FindBy(css = ".products li")
    private List<WebElementFacade> productsShopList;

    public void clickAddToCartButton(){clickOn(addToCartButton);}
    public void clickViewCartButton(){clickOn(viewCartButton);}

    public void verifyShopPageTitle(String text){shopPageTitle.getText();
    Assert.assertEquals("SHOP",text);
    }

    public void orderProductsDropdown(){
        clickOn(selectFromDropdown);
    }

    public void selectNewness(){
       orderProductsDropdown();clickOn(selectNewness);
    }
    public void selectHighToLow(){
       orderProductsDropdown();clickOn(selectHighToLow);
    }
    public void selectLowToHigh(){
        orderProductsDropdown();clickOn(selectLowToHigh);
    }
    public void selectPopularity(){
        orderProductsDropdown();clickOn(selectPopularity);
    }
    public void selectByAverageRating(){
        orderProductsDropdown();clickOn(selectByAverageRating);
    }
    public void selectFirstProductByPopularity(){firstProductByPopularity.click();}

    public void selectProductFromShopList(String product){
        for(WebElementFacade element : productsShopList){
            if(element.findElement(By.cssSelector(".collection_title")).getText().equalsIgnoreCase(product)){
                element.click();
               break;
           }
       }
    }


}
