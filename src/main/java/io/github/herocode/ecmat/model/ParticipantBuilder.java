/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.enums.RegularExpressions;
import io.github.herocode.ecmat.interfaces.ParticipantDao;
import io.github.herocode.ecmat.persistence.ParticipantDaoImpl;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantBuilder {

    private final String cpf;
    private final String email;

    private String password;
    private String name;
    private String titration;
    private Address address;
    private LocalDate birthDate;
    private Payment payment;
    private Phone phone;

    private ParticipantDao dao;

    public ParticipantBuilder(String cpf, String email) {

        dao = new ParticipantDaoImpl();

        this.cpf = cpf;
        this.email = email;
    }

    public ParticipantBuilder setTitration(String titration) {

        this.titration = titration;

        return this;
    }

    public ParticipantBuilder setName(String name) {

        this.name = name;

        return this;
    }

    public ParticipantBuilder setAddress(Address address) {

        this.address = address;

        return this;
    }

    public ParticipantBuilder setBirthDate(LocalDate birthDate) {

        this.birthDate = birthDate;

        return this;
    }

    public ParticipantBuilder setPayment(Payment payment) {

        this.payment = payment;

        return this;
    }

    public ParticipantBuilder setPassword(String password) {

        this.password = password;

        return this;
    }

    public ParticipantBuilder setPhone(Phone phone) {

        this.phone = phone;

        return this;
    }

    private void validateCpf() throws IllegalArgumentException {

        if (stringIsEmpty(cpf)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CPF.getErrorMessage());
        }

        CPFValidator cpfValidator = new CPFValidator();

        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CPF.getErrorMessage());
        }

        if (dao.existsCpf(cpf)) {

            throw new IllegalArgumentException(ErrorMessages.EXISTING_CPF.getErrorMessage());
        }

    }

    private void validateEmail() throws IllegalArgumentException {

        if (stringIsEmpty(email)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_EMAIL.getErrorMessage());
        }

        Pattern pattern = Pattern.compile(RegularExpressions.EMAIL_PATTERN.getRegex());

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL.getErrorMessage());
        }

        if (dao.existsEmail(email)) {
            throw new IllegalArgumentException(ErrorMessages.EXISTING_EMAIL.getErrorMessage());
        }

    }

    private boolean stringIsEmpty(String string) {

        return (string == null || string.trim().isEmpty());
    }

    public Participant build() throws IllegalArgumentException {

        validateEmail();
        validateCpf();

        Participant participant = new Participant();

        participant.setName(name);
        participant.setCpf(cpf);
        participant.setEmail(email);
        participant.setPhone(phone);
        participant.setAddress(address);
        participant.setTitration(titration);
        participant.setPassword(password);
        participant.setBirthDate(birthDate);

        ParticipantValidator.validateParticipant(participant);
        
        participant.setPassword(DigestUtils.sha1Hex(password));

        return participant;
    }

}
