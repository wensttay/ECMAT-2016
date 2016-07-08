/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.enums.CheckoutData;
import io.github.herocode.ecmat.interfaces.PaymentChecker;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PaymentCheckerImpl implements PaymentChecker {

    @Override
    public Map<String,String> checkPayment(String notificationCode) throws DOMException, IOException, ParserConfigurationException, SAXException {

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://ws.pagseguro.uol.com.br/v3/transactions/notifications/").
                append(notificationCode).
                append("?email=").
                append(CheckoutData.ACCOUNT_EMAIL.getValue()).
                append("&token=").
                append(CheckoutData.ACCOUNT_TOKEN.getValue());

        URL url = new URL(urlBuilder.toString());

        InputStream openStream = url.openStream();

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document doc = builder.parse(openStream);

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("transaction");

        Node node = nodeList.item(0);

        Element eElement = (Element) node;

        String date             = eElement.getElementsByTagName("date").item(0).getTextContent();
        String lastEventDate    = eElement.getElementsByTagName("lastEventDate").item(0).getTextContent();
        String code             = eElement.getElementsByTagName("code").item(0).getTextContent();
        String reference        = eElement.getElementsByTagName("reference").item(0).getTextContent();
        String status           = eElement.getElementsByTagName("status").item(0).getTextContent();

        Map<String,String> map = new HashMap<>();
        map.put("date", date);
        map.put("lastEventDate", lastEventDate);
        map.put("code", code);
        map.put("reference", reference);
        map.put("status", status);
        
        return map;
    }

}
