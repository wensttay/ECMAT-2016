package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Payment;
import java.util.List;
import java.util.Map;

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

    List<Payment> searchParticipantByAttribute(String key, String value);

    List<Payment> searchParticipantByAttributes(Map<String, String> map);

}
