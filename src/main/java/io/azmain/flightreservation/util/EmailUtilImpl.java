package io.azmain.flightreservation.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Value("${io.azmain.flightreservation.itinerary.email.subject}")
    private String EMAIL_SUBJECT;
    @Value("${io.azmain.flightreservation.itinerary.email.body}")
    private String EMAIL_BODY;

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEMail(String toAddress, String filePath) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;

        try {
            helper = new MimeMessageHelper(message,true);
            helper.setTo(toAddress);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText(EMAIL_BODY);
            helper.addAttachment("Flight Ticket",new File(filePath));
            sender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
