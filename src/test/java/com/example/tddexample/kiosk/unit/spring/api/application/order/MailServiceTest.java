package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.client.mail.MailSendClient;
import com.example.tddexample.kiosk.unit.spring.infrastructure.MailSendHistoryEntity;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ActiveProfiles("test")
//@SpringBootTest
//@Transactional
@ExtendWith(MockitoExtension.class)
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

    @Mock
    private MailSendClient mailSendClient;
    @Mock
    private MailSendHistoryJpaRepository mailSendHistoryJpaRepository;
    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail(){
        //given
//        MailSendClient mailSendClient = mock(MailSendClient.class);
//        MailSendHistoryRepository mailSendHistoryRepository = mock(MailSendHistoryRepository.class);

//        MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);

//        Mockito.when(mailSendClient.send(any(String.class), any(String.class), any(String.class), any(String.class)))
//            .thenReturn(true);
        BDDMockito.given(mailSendClient.send(any(String.class), any(String.class), any(String.class), any(String.class)))
            .willReturn(true);

        //when
        boolean result = mailService.send("", "", "", "");

        //then
        verify(mailSendHistoryJpaRepository, times(1)).save(any(MailSendHistoryEntity.class));
        assertThat(result).isTrue();
    }
}
