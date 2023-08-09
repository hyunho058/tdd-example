package com.example.tddexample.kiosk.unit.spring.api.application.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class MailServiceTest {
    @Autowired
    private MailService mailService;

    @DisplayName("메일 정송 성공하면 TRUE를 반환한다.")
    @Test
    void test() {
        //given
        LocalDate orderDate = LocalDate.of(2023, 8, 9);
        int ordersTotalPrice = 200000;

        String fromEmail = "no-replay@cafekiosk.com";
        String toEmail = "tet@test.com";
        String subject = String.format("[총 매출] %s", orderDate);
        String content = String.format("내용 총 매출 합계 = %s", ordersTotalPrice);

        //when
        boolean result = mailService.send(fromEmail, toEmail, subject, content);

        //then
        assertThat(result).isTrue();
    }
}
