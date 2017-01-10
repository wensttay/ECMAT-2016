package io.github.herocode.ecmat.entity;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantRecover {
    
    private String          token;
    private boolean         isValid;
    private String          participantEmail;

    public ParticipantRecover() {
    }

    public ParticipantRecover(String token, boolean isValid, String participantEmail) {
        this.token = token;
        this.isValid = isValid;
        this.participantEmail = participantEmail;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
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
    
}
