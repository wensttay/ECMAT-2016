/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.enums.CheckoutData;
import io.github.herocode.ecmat.interfaces.CheckoutCreator;
import java.math.BigDecimal;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class CheckoutCreatorImpl implements CheckoutCreator {

    @Override
    public String buildCheckout(Participant participant, String referenceCode) {

        Checkout checkout = new Checkout();

        Item checkoutItem = new Item(
                CheckoutData.ITEM_ID.getValue(),
                CheckoutData.ITEM_DESCRIPTION.getValue(),
                Integer.parseInt(CheckoutData.ITEM_SIZE.getValue()),
                new BigDecimal(CheckoutData.ITEM_PRICE.getValue())
        );

        Address checkoutShippingAddress = participant.getAddress();

        Sender checkoutSender = new Sender(
                participant.getName(),
                participant.getEmail()
        );
        
        checkout.addItem(checkoutItem);

        checkout.setShippingAddress(checkoutShippingAddress);

        checkout.setSender(checkoutSender);

        checkout.setCurrency(Currency.BRL);

        checkout.setReference(referenceCode);

        checkout.setRedirectURL(CheckoutData.REDIRECT_URL.getValue());

        checkout.setShippingType(ShippingType.NOT_SPECIFIED);

        try {
            
            boolean onlyCheckoutCode = false;

            checkout.setNotificationURL(CheckoutData.NOTIFICATION_URL.getValue());
            
            AccountCredentials ac = new AccountCredentials(CheckoutData.ACCOUNT_EMAIL.getValue(), CheckoutData.ACCOUNT_TOKEN.getValue());
            
            String checkoutUrl = checkout.register(ac, onlyCheckoutCode);
            System.out.println("dps do register");
            System.out.println(checkoutUrl);
            
            return checkoutUrl;

        } catch (PagSeguroServiceException e) {e.printStackTrace(); }

        return "";
    }

}
