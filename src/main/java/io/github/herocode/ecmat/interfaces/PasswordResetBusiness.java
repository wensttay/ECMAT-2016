/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.PasswordResetRequest;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface PasswordResetBusiness {
    
    boolean save(PasswordResetRequest resetRequest);
    
    PasswordResetRequest searchRequestPasswordById(int id) throws IllegalArgumentException;
    
    PasswordResetRequest searchRequestPasswordByToken(String token) throws IllegalArgumentException;
    
    boolean isPasswordResetRequestValid(PasswordResetRequest resetRequest);
    
    boolean updatePasswordResetRequest(PasswordResetRequest resetRequest);
    
}
