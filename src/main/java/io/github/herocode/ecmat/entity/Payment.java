/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Payment {
    
    private LocalDateTime   date;
    private LocalDateTime   lastEventDate;
    private String          code;
    private String          reference;
    private String          status;
    private URL             url;

    public Payment() { }

    public Payment(String reference) {
        this.reference = reference;
    }

    public Payment(LocalDateTime date, LocalDateTime lastEventDate, String code, String reference, String status, URL url) {
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

    public LocalDateTime getLastEventDate() {
        return lastEventDate;
    }

    public void setLastEventDate(LocalDateTime lastEventDate) {
        this.lastEventDate = lastEventDate;
    }
    
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
