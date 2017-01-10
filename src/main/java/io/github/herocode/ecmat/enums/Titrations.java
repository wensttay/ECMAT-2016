package io.github.herocode.ecmat.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum Titrations {

    STUDENT("Estudante"),
    GRADUATE("Graduado"),
    SPECIALIST("Especialista"),
    MASTER("Mestrado"),
    DOCTORAL("Doutorado"),
    POST_DOCTORAL("Pós Doutorado");

    String titration;

    Titrations(String titrationValue) {
        titration = titrationValue;
    }

    public String getTitration() {
        return titration;
    }

}
