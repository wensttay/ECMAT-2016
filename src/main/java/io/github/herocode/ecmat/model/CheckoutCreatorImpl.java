/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import io.github.herocode.ecmat.enums.CheckoutData;
import io.github.herocode.ecmat.interfaces.CheckoutCreator;
import java.math.BigDecimal;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class CheckoutCreatorImpl implements CheckoutCreator {

    @Override
    public String buildCheckout(String referenceCode) {

        Checkout checkout = new Checkout();

        Item checkoutItem = new Item(
                CheckoutData.ITEM_ID.getValue(),
                CheckoutData.ITEM_DESCRIPTION.getValue(),
                Integer.parseInt(CheckoutData.ITEM_SIZE.getValue()),
                new BigDecimal(CheckoutData.ITEM_PRICE.getValue())
        );

        Address checkoutShippingAddress = new Address(
                CheckoutData.SHIPPING_COUNTRY.getValue(),
                CheckoutData.SHIPPING_STATE.getValue(),
                CheckoutData.SHIPPING_CITY.getValue(),
                CheckoutData.SHIPPING_DISTRICT.getValue(),
                CheckoutData.SHIPPING_POSTAL_CODE.getValue(),
                CheckoutData.SHIPPING_STREET.getValue(),
                CheckoutData.SHIPPING_NUMBER.getValue(),
                CheckoutData.SHIPPING_COMPLEMENT.getValue()
        );

        Phone senderPhone = new Phone(
                CheckoutData.PHONE_AREA_CODE.getValue(),
                CheckoutData.PHONE_NUMBER.getValue()
        );

        Sender checkoutSender = new Sender(
                CheckoutData.SENDER_NAME.getValue(),
                CheckoutData.SENDER_EMAIL.getValue(),
                senderPhone
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

            AccountCredentials ac = new AccountCredentials(
                    CheckoutData.ACCOUNT_EMAIL.getValue(),
                    CheckoutData.ACCOUNT_TOKEN.getValue()
            );

            String checkoutUrl = checkout.register(ac, onlyCheckoutCode);

            return checkoutUrl;

        } catch (PagSeguroServiceException e) {
        }

        return "";
    }

}
