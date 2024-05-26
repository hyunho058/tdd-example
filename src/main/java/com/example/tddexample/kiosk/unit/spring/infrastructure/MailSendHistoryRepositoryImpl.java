package com.example.tddexample.kiosk.unit.spring.infrastructure;

import com.example.tddexample.kiosk.unit.spring.api.application.order.prot.MailSendHistoryRepository;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MailSendHistoryRepositoryImpl implements MailSendHistoryRepository {
    private final MailSendHistoryJpaRepository mailSendHistoryJpaRepository;
}
