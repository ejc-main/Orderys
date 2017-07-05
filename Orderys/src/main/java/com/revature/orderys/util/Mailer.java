package com.revature.orderys.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/*
 * change this class to work as you see fit.
 */

@Component
public class Mailer {
  
  private static String propertiesFile = "src/main/resources/mailer.properties";
  
  private static final Mailer INSTANCE = new Mailer();
  public static Mailer getInstance() { return Mailer.INSTANCE; }
  
  @Value("#{systemEnvironment['ORDERYS_EMAIL_USERNAME']}")
  private String username;
  @Value("#{systemEnvironment['ORDERYS_EMAIL_PASSWORD']}")
  private String password;
  
  private Mailer() {
    super();
    Properties p = new Properties();
    try {
      p.load(new FileReader(propertiesFile));
      this.username = p.getProperty("username");
      this.password = p.getProperty("password");
    } catch (IOException e) {
//      logger.alert(e.getMessage());
      e.printStackTrace();
    }
  }

  public boolean sendMail(String recipientEmail, String subject, String body) {
    boolean result = false;

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    try {
      InternetAddress fromAddr = new InternetAddress(username);
      InternetAddress toAddr = new InternetAddress(recipientEmail);

      MimeMessage message = new MimeMessage(session);
      message.setFrom(fromAddr);
      message.addRecipient(Message.RecipientType.TO, toAddr);
      message.setSubject(subject);
      message.setText(body);

      Transport.send(message);

      result = true;
    } catch (MessagingException mex) {
//      logger.alert(mex.getMessage());
      mex.printStackTrace();
    }

    return result;
  }
  
}