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
public enum EmailMessages {
    
    RECOVER_PASSWORD("Olá, recebemos sua solicitação para uma nova senha de "
            + "acesso ao Ecmat. Clique no link a seguir e defina sua nova senha, "
            + "lembrando que esse link irá expirar nos próximos 30 minutos. ");

    String message;
    
    private EmailMessages(String msg) {
        
        message = msg;
    }
    
    public String getMessage(){
        return message;
    }
    
}
