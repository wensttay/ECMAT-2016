/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.persistence.PasswordResetRequestDao;
import io.github.herocode.ecmat.interfaces.PasswordResetBusiness;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PasswordResetBusinessImpl implements PasswordResetBusiness {

    private Dao<PasswordResetRequest, Integer> dao;

    public PasswordResetBusinessImpl() {
        this.dao = new PasswordResetRequestDao();
    }

    @Override
    public boolean save(PasswordResetRequest resetRequest) throws IllegalArgumentException {

        return dao.save(resetRequest);
    }

    @Override
    public PasswordResetRequest searchRequestPasswordById(int id) throws IllegalArgumentException {

        PasswordResetRequest resetRequest = dao.searchById(id);

        if (resetRequest == null) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ID.getErrorMessage());
        }

        return resetRequest;
    }

    @Override
    public PasswordResetRequest searchRequestPasswordByToken(String token) throws IllegalArgumentException {

        try {
            return dao.searchByAttribute("token", token).get(0);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TOKEN.getErrorMessage());
        }

    }

    @Override
    public boolean isPasswordResetRequestValid(PasswordResetRequest resetRequest) {
        
        if(resetRequest.isValid()){
           
            LocalDateTime creationDate = resetRequest.getCreationDate();
            creationDate = creationDate.plusMinutes(30);
            
            LocalDateTime currentDate = LocalDateTime.now();
            
            boolean isValid = creationDate.isBefore(currentDate);
            
            return isValid;
        }
        
        return false;
    }

    @Override
    public boolean updatePasswordResetRequest(PasswordResetRequest resetRequest) {
        
        return dao.update(resetRequest);
    }

}
