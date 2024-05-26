package com.example.tddexample.kiosk.unit.spring.domain.history.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MailSendHistoryJpaRepository extends JpaRepository<MailSendHistoryEntity, Long> {

}
