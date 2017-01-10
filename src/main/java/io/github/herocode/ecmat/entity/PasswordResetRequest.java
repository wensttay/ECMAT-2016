package io.github.herocode.ecmat.entity;

import java.time.LocalDateTime;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PasswordResetRequest {
    
    private int             id;
    private String          token;
    private boolean         isValid;
    private LocalDateTime   creationDate;
    private String          participantEmail;

    public PasswordResetRequest() {
    }

    public PasswordResetRequest(int id, String token, boolean isValid, LocalDateTime creationDate, String participantEmail) {
        this.id = id;
        this.token = token;
        this.isValid = isValid;
        this.creationDate = creationDate;
        this.participantEmail = participantEmail;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
}
