package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.client.mail.MailSendClient;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistory;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MailService { ///mail send and history save service

    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;

    public boolean send(String fromEmail,
                        String toEmail,
                        String subject,
                        String content) {

        boolean result = mailSendClient.send(fromEmail, toEmail, subject, content);

        if (result) {
            mailSendHistoryRepository.save(new MailSendHistory(fromEmail, toEmail, subject, content));
            return true;
        }
        return false;
    }
}
