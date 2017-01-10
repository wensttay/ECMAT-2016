package io.github.herocode.ecmat.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum CheckoutData {
    
    ITEM_ID("Inscrição Ecmat"), 
    ITEM_DESCRIPTION("Inscrição para o III Ecmat"), 
    ITEM_SIZE("1"), 
    ITEM_PRICE("20.00"),
    
    SHIPPING_COUNTRY("BRA"),
    SHIPPING_STATE("PB"),
    SHIPPING_CITY("Cajazeiras"),
    SHIPPING_DISTRICT("Centro"),
    SHIPPING_POSTAL_CODE("58900-000"),
    SHIPPING_STREET("Rua José Antônio da Silva"),
    SHIPPING_NUMBER("300"),
    SHIPPING_COMPLEMENT(""),
    
    SENDER_NAME("Ecmat III"),
    SENDER_EMAIL("ecmat2016@gmail.com"),
    
    PHONE_AREA_CODE("83"),
    PHONE_NUMBER("996401322"),
    
    REDIRECT_URL("http://www.ecmat.com.br"),
    
    ACCOUNT_EMAIL("msndeairton@hotmail.com"),
    ACCOUNT_TOKEN("ECA03FFDFA40450187391F3568F84460"),
    
    NOTIFICATION_URL("http://www.ecmat.com.br/PaymentNotification");
    
    String value;
    
    private CheckoutData(String dataValue) {

        value = dataValue;
    }
    
    public String getValue(){
        return value;
    }
}
