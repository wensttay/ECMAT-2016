/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.enums.RegularExpressions;
import io.github.herocode.ecmat.enums.Titrations;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantValidator {

    public static void validateParticipant(Participant participant) throws IllegalArgumentException {

        validateAddress(participant.getAddress());
        validateName(participant.getName());
        validateBirthDate(participant.getBirthDate());
        validateTitration(participant.getTitration());
        validatePhone(participant.getPhone());
        validatePassword(participant.getPassword());
        
    }

    private static void validateAddress(Address address) throws IllegalArgumentException {

        if (stringIsEmpty(address.getCountry())) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_COUNTRY.getErrorMessage());
        }

        if (stringIsEmpty(address.getCity())) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CITY.getErrorMessage());
        }

        if (stringIsEmpty(address.getState())) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_STATE.getErrorMessage());
        }

        if (address.getCity().length() > 50) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_CITY_NAME.getErrorMessage());
        }

        if (address.getDistrict().length() > 50) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_DISTRICT_NAME.getErrorMessage());
        }

        if (address.getPostalCode().length() > 8) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_POSTAL_CODE.getErrorMessage());
        }

        if (address.getStreet().length() > 50) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_STREET_NAME.getErrorMessage());
        }

        if (address.getNumber().length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_HOUSE_NUMBER.getErrorMessage());
        }

        if (address.getState().length() > 2) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_STATE_NAME.getErrorMessage());
        }

    }

    private static void validateTitration(String titration) throws IllegalArgumentException {

        if (stringIsEmpty(titration)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_TITRATION.getErrorMessage());
        }

        boolean equals = false;

        for (Titrations t : Titrations.values()) {
            if (t.getTitration().equals(titration)) {
                equals = true;
                break;
            }
        }

        if (!equals) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TITRATION.getErrorMessage());
        }

    }

    private static void validateName(String name) throws IllegalArgumentException {

        if (stringIsEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_NAME.getErrorMessage());
        }

        if (name.split(" ").length <= 1) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME.getErrorMessage());
        }

    }

    private static void validatePhone(Phone phone) throws IllegalArgumentException {

        if (stringIsEmpty(phone.getAreaCode())) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_PHONE_DDD.getErrorMessage());
        }

        if (stringIsEmpty(phone.getNumber())) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_PHONE_NUMBER.getErrorMessage());
        }

        if (phone.getAreaCode().length() > 2) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_DDD.getErrorMessage());
        }

        if (phone.getNumber().length() > 12) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PHONE.getErrorMessage());
        }

    }

    private static void validateBirthDate(LocalDate birthDate) throws IllegalArgumentException {

        DateTimeFormatter formartter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate minimunBirthDate = LocalDate.parse("2013-01-01", formartter);

        if (birthDate == null || birthDate.isAfter(minimunBirthDate)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BIRTH_DATE.getErrorMessage());
        }

    }

    private static void validatePassword(String password) throws IllegalArgumentException {

        if (stringIsEmpty(password)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PASSWORD.getErrorMessage());
        }

        Pattern pattern = Pattern.compile(RegularExpressions.PASSWORD_PATTERN.getRegex());

        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches() || password.length() < 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PASSWORD.getErrorMessage());
        }

    }

    private static boolean stringIsEmpty(String string) {

        return (string == null || string.trim().isEmpty());
    }

}
