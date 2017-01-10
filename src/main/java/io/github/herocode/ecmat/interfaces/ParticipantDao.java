package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.entity.ShortCourse;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface ParticipantDao extends Dao<Participant, Integer> {

    List<ShortCourse> getRegisteredShortCourse(Participant participant);

    Participant save(Participant participant, String paymentId);

    Participant save(Participant participant, Payment payment);

    boolean existsEmail(String email);

    boolean existsCpf(String cpf);

    String getEmailFromPaymentReference(String paymentReference);

}
