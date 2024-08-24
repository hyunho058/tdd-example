package com.example.tddexample.kiosk.unit.spring.infrastructure;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "mail_send_history")
@Entity
public class MailSendHistoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String content;

    protected MailSendHistoryEntity() {
    }

    public MailSendHistoryEntity(String fromEmail,
                                 String toEmail,
                                 String subject,
                                 String content) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.subject = subject;
        this.content = content;
    }
}
