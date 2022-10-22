package com.old.test;


import lombok.extern.slf4j.Slf4j;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

@Slf4j
public class EmailUtil {

    private static String emailRegular = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

    public static boolean validEmail(String emailAddress) {
        return Pattern.matches(emailRegular, emailAddress);
    }


    private static String fromMailAddress = "";
    private static String fromMailPwd = "";
    private static String fromMailSMTPHost = "";
    private static String smtpPort = "465";

    private static Properties setProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", fromMailSMTPHost);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");

        return properties;
    }

    private static Message setMail(Session session, String toEmailAdress, String emailTitle, String emailContent) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromMailAddress, fromMailAddress, "UTF-8"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAdress, toEmailAdress, "UTF-8"));
        message.setSubject(emailTitle);
        message.setContent(emailContent, "text/html;charset=utf-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    private static Session setSession() {
        Properties properties = setProperties();
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        return session;
    }


    public static boolean sendEmail(String toEmailAdress, String emailContent, String emailTitle) {
        Session session = setSession();
        try {
            Message message = setMail(session, toEmailAdress, emailTitle, emailContent);
            Transport transport = session.getTransport();
            transport.connect(fromMailAddress, fromMailPwd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            log.info(e.getMessage());
            log.error("toEmailAdress = " + toEmailAdress + ", emailContent = " + emailContent + ", emailTitle = " + emailTitle + ", error = " + e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EmailUtil.sendEmail("1193131227@qq.com", "testContent", "testTitle");
    }
}


