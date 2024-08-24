package com.example.tddexample.kiosk.unit.spring.domain.history.mail;

import com.example.tddexample.kiosk.unit.spring.infrastructure.MailSendHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailSendHistoryJpaRepository extends JpaRepository<MailSendHistoryEntity, Long> {

}
