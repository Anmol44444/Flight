package io.azmain.flightreservation.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEMail(String toAddress, String filePath) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;

        try {
            helper = new MimeMessageHelper(message,true);
            helper.setTo(toAddress);
            helper.setSubject("Your Flight Reservation");
            helper.setText("Please take a printout of your ticket.");
            helper.addAttachment("Flight Ticket",new File(filePath));
            sender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
