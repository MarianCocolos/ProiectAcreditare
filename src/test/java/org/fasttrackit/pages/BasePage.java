package org.fasttrackit.pages;

import net.thucydides.core.pages.PageObject;

public class BasePage extends PageObject {


    public int getPriceFromString(String price) {

        return Integer.parseInt(price
                .replace(" RON", "")
                .replace(",", ""));
    }
}