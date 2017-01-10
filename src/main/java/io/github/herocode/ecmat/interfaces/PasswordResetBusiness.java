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
