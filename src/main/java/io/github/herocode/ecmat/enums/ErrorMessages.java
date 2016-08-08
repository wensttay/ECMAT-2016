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
public enum ErrorMessages{

    EMPTY_NAME("Campo nome vazio, informe seu nome."),
    EMPTY_EMAIL("Campo e-mail vazio, informe um e-mail válido."),
    EMPTY_CPF("Campo CPF vazio, informe um CPF válido."),
    EMPTY_TITRATION("Campo titulação vazio."),
    EMPTY_COUNTRY("Campo país vazio."),
    EMPTY_STATE("Campo estado vazio."),
    EMPTY_CITY("Campo cidade vazio."),
    EMPTY_PHONE_NUMBER("Campo telefone vazio."),
    EMPTY_PHONE_DDD("Campo DDD vazio."),
    INVALID_CPF("O CPF informado é inválido."),
    INVALID_EMAIL("O e-mail informado é inválido."),
    INVALID_PASSWORD("A senha deve conter ao menos 6 caracteres alfa-numéricos ou caracteres especiais como .,_"),
    INVALID_TITRATION("Titulação inválida."),
    INVALID_TOKEN("Token inválido."),
    INVALID_ID("Id inválido."),
    INVALID_NAME("É necessario informar o nome e sobrenome."),
    INVALID_PHONE("Este número de telefone é inválido"),
    INVALID_BIRTH_DATE("Esta data de nascimento parece estar incorreta, informe sua data de nascimento no formato dia/mês/ano"),
    TOO_LONG_CITY_NAME("Aparentemente a cidade informada não existe."),
    TOO_LONG_DISTRICT_NAME("Aparentemente o bairro informado não existe."),
    TOO_LONG_POSTAL_CODE("Aparentemente o CEP informado não existe."),
    TOO_LONG_STREET_NAME("Aparentemente a rua informada não existe."),
    TOO_LONG_HOUSE_NUMBER("Aparentemente este numero residencial não existe."),
    TOO_LONG_STATE_NAME("Aparentemente este estado não existe."),
    TOO_LONG_DDD("Aparentemente este DDD não existe"),
    EXISTING_EMAIL("O E-mail informado já está cadastrado."),
    EXISTING_CPF("O CPF informado já está cadastrado."),
    DIFFERENT_PASSWORDS("As senhas inseridas são diferentes, elas devem ser iguais."),
    FAIL_LOGIN("Não foi encontrado este usuário em nosso sistema, verifique o "
            + "E-mail e senha e tente novamente."),
    
    DESLOGED_ACCOUNT("É necessário efetuar o login efetuar essa operação. </br>"
            + "Entre na sua conta ou crie uma agora mesmo no site principal na aba de \"Inscrição\"."),
    PAYMENT_NOT_COMPLETE("Para se efetuar essa operação é necessário que a inscrição e o pagamento"
            + " estejam totalmente concluidos!</br> Visite o Painel Principal para mais informações. "),
    FILLED_SHORT_COURSE("O mini curso está com todas as vagas preenchidas. </br>"
            + "Atualmente todas as vagas foram ocupadas, sentimos muito."),
    PARTICIPANT_IS_ENROLLED_IN_ANOTHER_SHORT_COURSE("Esta conta ja está matriculado para"
            + " um minicurso/oficina no mesmo turno. </br>"
            + "Atualmente as inscrições estão limitadas a uma por turno (manhã, tarde e noite)"),
    SHORT_COURSE_IS_IN_PROGRESS_OR_ITS_OVER("O minicurso/oficina  escolhido já terminou ou está em progresso"
            + " no momento. </br>"
            + "Essa ação não é mais possivel, sentimos muito."),
    
    SHORT_COURSE_NOT_EXISTS("O minicurso/oficina escolhido não foi encontrado. </br>"
            + "Algum erro pode ter acontecido, por favor tente atualizar a página."),
    PARTICIPANT_ALREADY_REGISTERED("Esta conta já está matriculado neste mini curso. </br>"
            + "Algum erro pode ter acontecido, por favor tente atualizar a página."),
    PARTICIPANT_NOT_ALREADY_REGISTRED("Esta conta não está está registrada nesse minicurso/oficina."
            + "Algum erro pode ter acontecido, por favor tente atualizar a página."),
    UNKNOW_ERROR("Não foi possivel efetuar essa operação."
            + "Algum erro pode ter acontecido, por favor tente atualizar a página.");

    String errorMessage;

    ErrorMessages(String message){
        errorMessage = message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
