/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Payment;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface PaymentBusiness {
    
    boolean save(Payment payment);

    boolean delete(Payment payment);

    boolean update(Payment payment);

    Payment searchById(String reference);

    List<Payment> listAll();

}
