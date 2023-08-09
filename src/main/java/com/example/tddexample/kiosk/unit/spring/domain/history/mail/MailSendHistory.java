package com.example.tddexample.kiosk.unit.spring.domain.history.mail;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class MailSendHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String content;

    protected MailSendHistory() {
    }

    public MailSendHistory(String fromEmail,
                           String toEmail,
                           String subject,
                           String content) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.subject = subject;
        this.content = content;
    }
}
