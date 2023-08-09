package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.client.mail.MailSendClient;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistory;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ActiveProfiles("test")
//@SpringBootTest
//@Transactional
class MailServiceTest {
//    @Autowired
//    private MailService mailService;
//
//    @DisplayName("메일 정송 성공하면 TRUE를 반환한다.")
//    @Test
//    void test() {
//        //given
//        LocalDate orderDate = LocalDate.of(2023, 8, 9);
//        int ordersTotalPrice = 200000;
//
//        String fromEmail = "no-replay@cafekiosk.com";
//        String toEmail = "tet@test.com";
//        String subject = String.format("[총 매출] %s", orderDate);
//        String content = String.format("내용 총 매출 합계 = %s", ordersTotalPrice);
//
//        //when
//        boolean result = mailService.send(fromEmail, toEmail, subject, content);
//
//        //then
//        assertThat(result).isTrue();
//    }



    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail(){
        //given
        MailSendClient mailSendClient = mock(MailSendClient.class);
        MailSendHistoryRepository mailSendHistoryRepository = mock(MailSendHistoryRepository.class);

        MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);

        //stubbing
        when(mailSendClient.send(any(String.class), any(String.class), any(String.class), any(String.class)))
            .thenReturn(true);

        //when
        boolean result = mailService.send("", "", "", "");

        //then
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
        assertThat(result).isTrue();
    }
}
