/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.interfaces.PaymentBusiness;
import io.github.herocode.ecmat.persistence.PaymentDao;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PaymentBusinessImpl implements PaymentBusiness{
    
    private Dao<Payment,String> paymentDao;

    public PaymentBusinessImpl() {
        
        this.paymentDao = new PaymentDao();
    }

    @Override
    public boolean save(Payment payment) {
        
        return paymentDao.save(payment);
    }

    @Override
    public boolean delete(Payment payment) {
        
        return paymentDao.delete(payment);
    }

    @Override
    public boolean update(Payment payment) {
        
        return paymentDao.update(payment);
    }

    @Override
    public Payment searchById(String reference) {
        
        return paymentDao.searchById(reference);
    }

    @Override
    public List<Payment> listAll() {
        
        return Collections.unmodifiableList(paymentDao.listAll());
    }
    
}
