package com.example.final_traveling;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Mail {
    static void send_email(String to,String body){
        final String username = "tourmanagementsystemseca@gmail.com";
        final String password = "jqmpxddbbzvflqgj";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tourmanagementsystemseca@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("Section A Tour Management 2023");
            message.setText(body);

            Transport.send(message);

            System.out.println("        Email sent Successfully to :"+to);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("         Unable to send email invalid address or network error");
        }
    }
}