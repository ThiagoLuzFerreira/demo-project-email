package com.thiago.demoprojectemail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "email-database")
public class Email implements Serializable {

    @Id
    private String emailId;
    private String personId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public Email() {
    }

    public Email(String emailId, String personId, String emailFrom, String emailTo, String subject, String text, LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.emailId = emailId;
        this.personId = personId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    public Email(String personId, String emailFrom, String emailTo, String subject, String text, LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.personId = personId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(emailId, email.emailId) && Objects.equals(personId, email.personId) && Objects.equals(emailFrom, email.emailFrom) && Objects.equals(emailTo, email.emailTo) && Objects.equals(subject, email.subject) && Objects.equals(text, email.text) && Objects.equals(sendDateEmail, email.sendDateEmail) && Objects.equals(statusEmail, email.statusEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId, personId, emailFrom, emailTo, subject, text, sendDateEmail, statusEmail);
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId='" + emailId + '\'' +
                ", personId='" + personId + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", sendDateEmail=" + sendDateEmail +
                ", statusEmail=" + statusEmail +
                '}';
    }
}
