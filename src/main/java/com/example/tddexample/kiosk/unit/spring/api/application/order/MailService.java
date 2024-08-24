package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.client.mail.MailSendClient;
import com.example.tddexample.kiosk.unit.spring.infrastructure.MailSendHistoryEntity;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService implements MessageSender { ///mail send and history save service

    private final MailSendClient mailSendClient;
    private final MailSendHistoryJpaRepository mailSendHistoryJpaRepository;

    public boolean send(String from,
                        String to,
                        String subject,
                        String content) {

        boolean result = mailSendClient.send(from, to, subject, content);

        if (result) {
            mailSendHistoryJpaRepository.save(new MailSendHistoryEntity(from, to, subject, content));
            return true;
        }
        return false;
    }
}
