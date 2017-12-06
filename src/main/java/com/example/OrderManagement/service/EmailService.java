package com.example.OrderManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.example.OrderManagement.exception.EmailException;

@Service
public class EmailService {

    public final static String to = "";
    public final static String from = "";
    private MailSender mailSender;
    @Autowired
    public void EmailUtility(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String text, String to, String from) throws EmailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(text);
        message.setTo(to);
        message.setFrom(from);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new EmailException(e.getMessage());
        }
    }

    public void sendEmail(String text, String to) throws EmailException {
        this.sendEmail(text, to, EmailService.from);
    }
}
