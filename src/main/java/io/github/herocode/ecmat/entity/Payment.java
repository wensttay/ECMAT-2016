/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import java.net.URL;
import java.time.LocalDate;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Payment {
    
    private LocalDate   date;
    private LocalDate   lastEventDate;
    private String      code;
    private String      reference;
    private String      status;
    private URL         url;

    public Payment() { }

    public Payment(String code) {
        this.code = code;
    }

    public Payment(LocalDate date, LocalDate lastEventDate, String code, String reference, String status, URL url) {
        this.date = date;
        this.lastEventDate = lastEventDate;
        this.code = code;
        this.reference = reference;
        this.status = status;
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public LocalDate getLastEventDate() {
        return lastEventDate;
    }

    public void setLastEventDate(LocalDate lastEventDate) {
        this.lastEventDate = lastEventDate;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
