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
    
    INVALID_CPF("O CPF informado é inválido"),
    INVALID_EMAIL("O e-mail informado é inválido");
    
    String errorMessage;
    
    ErrorMessage(String message){
        errorMessage = message;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }
    
}
