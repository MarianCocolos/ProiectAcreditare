package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(css = ".products li")
    private List<WebElementFacade> productsList;
    @FindBy(css = ".entry-title.ak-container")
    private WebElementFacade searchResultsText;
    @FindBy(css = ".woocommerce-info")
    private WebElementFacade productResultsMessage;

    public boolean checkListForProduct(String productName){
        for(WebElementFacade element : productsList){
            if(element.findElement(By.cssSelector(".collection_title")).getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }
    public void selectProductFromList(String product){
        for(WebElementFacade element : productsList){
            if(element.findElement(By.cssSelector(".collection_title")).getText().equalsIgnoreCase(product)){
                element.click();
                break;
            }
        }
    }

    public void verifySearchResultsText(String textFromElement){searchResultsText.getText();
        Assert.assertEquals("SEARCH RESULTS: “123@%&*(”",textFromElement);
    }
    public void verifyProductResultsMessage(String textFromElement){productResultsMessage.getText();
        Assert.assertEquals("No products were found matching your selection.",textFromElement);}

}

