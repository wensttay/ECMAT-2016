/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.persistence.PaymentDao;
import java.net.URL;
import java.time.LocalDate;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Participant {

    private int                 id;
    private String              name;
    private LocalDate           birthDate;
    private Phone               phone;
    private String              titration;
    private String              cpf;
    private String              email;
    private String              password;
    private Address             address;
    private Dao<Payment,String> paymentDao;

    public Participant() {
        
    }

    public Participant(int id, String name, LocalDate birthDate, Phone phone, String titration, String cpf, String email, String password, Address address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.titration = titration;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        
        if(paymentDao == null){
            paymentDao = new PaymentDao();
        }
        
        return paymentDao.searchById(String.valueOf(cpf.hashCode()));
    }
    
    public void setPayment(Payment payment){
     
        if(paymentDao == null){
            paymentDao = new PaymentDao();
        }
        
        paymentDao.save(payment);   
    }
    
    public String getFirstName(){
        
        int endOfName = name.indexOf(" ");
        
        return name.substring(0, endOfName);
    }

    public String getPaymentStatus(){
        
        return getPayment().getStatus();
    }
    
    public URL getPaymentUrl(){
        
        return getPayment().getUrl();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTitration() {
        return titration;
    }

    public void setTitration(String titration) {
        this.titration = titration;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
