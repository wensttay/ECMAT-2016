/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import java.time.LocalDate;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Participant {

    private int         id;
    private String      name;
    private String      email;
    private String      cpf;
    private LocalDate   birthDate;

    public Participant() { }

    public Participant(int id, String name, String email, LocalDate birthDate, String cpf) {
        this.id         = id;
        this.name       = name;
        this.email      = email;
        this.birthDate  = birthDate;
        this.cpf        = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(" Name: ").
                append(name).
                append(" Date Of Birth: ").
                append(birthDate).
                append(" email: ").
                append(email);
        
        return sb.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o){
        
        if(o == null)
            return false;
        
        if(this == o)
            return true;
        
        
        if(!(o instanceof Participant))
            return false;
        
        Participant participantToCompare = (Participant) o;
        
        if(!this.cpf.equals(participantToCompare.getCpf()))
            return false;
        
        return true;
    }

}
