/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface PaymentChecker {
    
    public Map<String,String> checkPayment(String notificationCode) throws DOMException,IOException,ParserConfigurationException,SAXException;
    
}
