package com.example.tddexample.pay;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 납부한 금액 기준으로 서비스 만료일을 계산하는 기능
 * 1.서비스를 사용하려면 매달 1만 원을 선불로 납부한다. (납부일 기준으로 한 달 뒤가 서비스 만료일이 된다)
 * 2.2개월 이상 요금을 납부할 수 있다.
 * 3.10만 원을 납부하면 서비스를 1년제공한다.
 */
public class PaymentCalculatorTest {
    @Test
    void 만원을_납부하면_한달_뒤_가_만료일이_된다() {
        assertExpiryDate(
                LocalDate.of(2023, 1, 3),
                10_000,
                LocalDate.of(2023, 2, 3)
        );

        assertExpiryDate(
                LocalDate.of(2023, 5, 5),
                10_000,
                LocalDate.of(2023, 6, 5)
        );

        assertExpiryDate(
                LocalDate.of(2017, 8, 18),
                10_000,
                LocalDate.of(2017, 9, 18)
        );

        assertExpiryDate(
                LocalDate.of(2023, 12, 18),
                10_000,
                LocalDate.of(2024, 1, 18)
        );

        assertExpiryDate(
                LocalDate.of(2023, 5, 31),
                10_000,
                LocalDate.of(2023, 6, 30)
        );
    }

    private void assertExpiryDate(LocalDate paymentDate,
                                  int payAmount,
                                  LocalDate expectedExpiryDate) {

        Payment payment = new Payment(paymentDate, payAmount);
        assertEquals(
                expectedExpiryDate,
                payment.expireDate()
        );
    }

    @Test
    void 삼만원을_납부하면_세달_뒤_가_만료일이_된다() {
        LocalDate paymentDate = LocalDate.of(2023, 1, 1);
        int paymentAmount = 30_000;

        Payment payment = new Payment(paymentDate, paymentAmount);

        assertEquals(
                LocalDate.of(2023, 4, 1),
                payment.expireDate()
        );
    }

    @Test
    void 이전_납부일과_만료일_일자가_다를때_만원_납부() {
        LocalDate previousPaymentDate = LocalDate.of(2023, 1, 31);
        int previousPaymentAmount = 10_000;
        LocalDate paymentDate = LocalDate.of(2023, 2, 28);
        int paymentAmount = 10_000;

        Payment payment = new Payment(
                previousPaymentDate,
                previousPaymentAmount,
                paymentDate,
                paymentAmount
        );

        assertEquals(
                LocalDate.of(2023, 3, 31),
                payment.expireDate()
        );
    }

    @Test
    void 십만원을_납부하면_열두달_뒤_가_만료일이_된다() {
        LocalDate paymentDate = LocalDate.of(2023, 1, 1);
        int paymentAmount = 100_000;

        Payment payment = new Payment(paymentDate, paymentAmount);

        assertEquals(
                LocalDate.of(2024, 1, 1),
                payment.expireDate()
        );
    }

    @Test
    void 이전_납부일_이후_이용일이남았을때_12만원_추가_납부_하면_만료일은_15개월_이후_이다() {
        LocalDate previousPaymentDate = LocalDate.of(2023, 1, 31);
        int previousPaymentAmount = 10_000;
        LocalDate paymentDate = LocalDate.of(2023, 2, 20);
        int paymentAmount = 120_000;

        Payment payment = new Payment(
                previousPaymentDate,
                previousPaymentAmount,
                paymentDate,
                paymentAmount
        );

        assertEquals(
                LocalDate.of(2024 , 4, 30),
                payment.expireDate()
        );
    }

    @Test
    void 사용_만료_이후_다시_이용권_한달_구매() {
        LocalDate previousPaymentDate = LocalDate.of(2023, 1, 31);
        int previousPaymentAmount = 10_000;
        LocalDate paymentDate = LocalDate.of(2023, 3, 31);
        int paymentAmount = 10_000;

        Payment payment = new Payment(
                previousPaymentDate,
                previousPaymentAmount,
                paymentDate,
                paymentAmount
        );

        assertEquals(
                LocalDate.of(2023, 4, 30),
                payment.expireDate()
        );
    }
}
