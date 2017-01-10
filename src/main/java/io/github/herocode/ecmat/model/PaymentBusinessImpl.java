package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.interfaces.PaymentBusiness;
import io.github.herocode.ecmat.persistence.PaymentDao;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PaymentBusinessImpl implements PaymentBusiness {

    private Dao<Payment, String> paymentDao;

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

    @Override
    public List<Payment> searchParticipantByAttribute(String key, String value) {

        return Collections.unmodifiableList(paymentDao.searchByAttribute(key, value));
    }

    @Override
    public List<Payment> searchParticipantByAttributes(Map<String, String> map) {

        return Collections.unmodifiableList(paymentDao.searchByAttributes(map));
    }

}
