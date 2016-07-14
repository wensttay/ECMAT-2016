/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum ErrorMessage {

    EMPTY_NAME("Campo nome vazio, informe seu nome."),
    EMPTY_EMAIL("Campo e-mail vazio, informe um e-mail válido."),
    EMPTY_CPF("Campo CPF vazio, informe um CPF válido."),
    EMPTY_TITRATION("Campo titulação vazio"),
    EMPTY_COUNTRY("Campo país vazio"),
    EMPTY_STATE("Campo estado vazio"),
    EMPTY_CITY("Campo cidade vazio"),
    
    INVALID_CPF("O CPF informado é inválido."),
    INVALID_EMAIL("O e-mail informado é inválido."),
    INVALID_PASSWORD("A senha deve conter ao menos 6 caracteres alfa-numéricos ou caracteres especiais como .,_"),
    INVALID_TITRATION("Titulação inválida."),
    
    FILLED_SHORT_COURSE("O mini curso está com todas as vagas preenchidas."),
    PARTICIPANT_ALREADY_REGISTERED("O participante já está matriculado neste mini curso."),
    PARTICIPANT_IS_ENROLLED_IN_ANOTHER_SHORT_COURSE("O participante ja está matriculado para"
            + " um minicurso no mesmo horário"),
    
    MISSING_PAYMENT("É necessário efetuar o pagamento da inscrição para registrar-se em"
            + " um minicurso.");

    String errorMessage;

    ErrorMessage(String message) {
        errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
