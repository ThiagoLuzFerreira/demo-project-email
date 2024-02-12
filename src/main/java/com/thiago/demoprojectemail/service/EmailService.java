package com.thiago.demoprojectemail.service;

import com.thiago.demoprojectemail.model.Email;
import com.thiago.demoprojectemail.model.StatusEmail;
import com.thiago.demoprojectemail.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public Email sendEmail(Email email){
        try{

            email.setEmailFrom(emailFrom);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email.getEmailTo());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getText());
            javaMailSender.send(mailMessage);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}
