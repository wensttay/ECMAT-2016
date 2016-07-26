/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface CheckoutCreator {
    
    /**
     * Build a checkout in the PagSeguro system and return the payment URL
     * @return Payment URL for this checkout
     */
    String buildCheckout(Participant participant, String referenceCode);
    
    /**
     * Build a checkout in the PagSeguro system and return the payment URL
     * @return Payment URL for this checkout
     */
    default String buildCheckout(Participant participant, int referenceCode){
        
        return buildCheckout(participant, String.valueOf(referenceCode));
    }
    
}
