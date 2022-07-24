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
    @FindBy(css = ".orderby")
    private WebElementFacade selectProductsDropdown;
    @FindBy(css = ".ajax_add_to_cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".wc-forward")
    private WebElementFacade viewCartButton;
    @FindBy(css = ".products li")
    private List<WebElementFacade> productsShopList;
    @FindBy(css = ".entry-summary .entry-title")
    private WebElementFacade productTitleSelected;
    @FindBy(css = ".product-name a")
    private WebElementFacade productNameFromCart;

    public void clickAddToCartButton(){clickOn(addToCartButton);}
    public void clickViewCartButton(){clickOn(viewCartButton);}

    public void verifyShopPageTitle(String text){shopPageTitle.getText();
    Assert.assertEquals("SHOP",text);
    }
    public void selectNewness(){
       selectFromDropdown(selectProductsDropdown,"Sort by newness");
    }
    public void selectHighToLow(){
       selectFromDropdown(selectProductsDropdown,"Sort by price: high to low");
    }
    public void selectLowToHigh(){
        selectFromDropdown(selectProductsDropdown,"Sort by price: low to high");
    }
    public void selectPopularity(){
        selectFromDropdown(selectProductsDropdown,"Sort by popularity");
    }
    public void selectByAverageRating(){
        selectFromDropdown(selectProductsDropdown,"Sort by average rating");
    }

    public void verifyProductNameSelected(String textFromElement){productTitleSelected.getText();
    Assert.assertEquals("Hoodie with Zipper",textFromElement);}
    public void verifyProductNameAddedToCart(String textFromElement){productNameFromCart.getText();
    Assert.assertEquals("Album",textFromElement);}

    public void selectProductFromShopList(String product){
        for(WebElementFacade element : productsShopList){
            if(element.findElement(By.cssSelector(".collection_title")).getText().equalsIgnoreCase(product)){
                element.click();
               break;
           }
       }
    }


}
