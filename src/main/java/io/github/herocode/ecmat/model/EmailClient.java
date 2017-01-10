package io.github.herocode.ecmat.model;

import com.sendgrid.*;
import java.io.IOException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class EmailClient {

    public static String defaultSender = "devecmat2016@gmail.com";

    public static void sendEmail(String subject, String receiver, String message, String sender) {

        new Thread() {

            @Override
            public void run() {

                Email from = new Email(sender);
                Email to = new Email(receiver);
                Content content = new Content("text/plain", message);

                Mail mail = new Mail(from, subject, to, content);

                SendGrid sg = new SendGrid("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");

                Request request = new Request();

                try {
                    request.method = Method.POST;
                    request.endpoint = "mail/send";
                    request.body = mail.build();
                    Response response = sg.api(request);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println(receiver);
                    System.out.println(message);
                }
            }
        }.start();

    }

}
