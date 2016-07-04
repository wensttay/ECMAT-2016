/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum CheckoutData {
    
    ITEM_ID(""), 
    ITEM_DESCRIPTION(""), 
    ITEM_SIZE(""), 
    ITEM_PRICE(""),
    
    SHIPPING_COUNTRY(""),
    SHIPPING_STATE(""),
    SHIPPING_CITY(""),
    SHIPPING_DISTRICT(""),
    SHIPPING_POSTAL_CODE(""),
    SHIPPING_STREET(""),
    SHIPPING_NUMBER(""),
    SHIPPING_COMPLEMENT(""),
    
    SENDER_NAME(""),
    SENDER_EMAIL(""),
    SENDER_PHONE(""),
    
    REDIRECT_URL(""),
    
    ACCOUNT_EMAIL(""),
    ACCOUNT_TOKEN("");
    
            
    
    String value;
    
    private CheckoutData(String dataValue) {

        value = dataValue;
    }
    
    public String getValue(){
        return value;
    }
}
