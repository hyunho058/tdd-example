package com.example.tddexample.pay;

import java.time.LocalDate;

/**
 * 납부한 금액 기준으로 서비스 만료일을 계산하는 기능
 * 1.서비스를 사용하려면 매달 1만 원을 선불로 납부한다. (납부일 기준으로 한 달 뒤가 서비스 만료일이 된다)
 * 2.2개월 이상 요금을 납부할 수 있다.
 * 3.10만 원을 납부하면 서비스를 1년제공한다.
 */
public class Payment {
    private final LocalDate previousPaymentDate;
    private final Integer previousPaymentAmount;
    private final LocalDate paymentDate;
    private final Integer paymentAmount;
    private final static int MINIMUM_USAGE_AMOUNT = 10_000;
    private final static int NUMBER_OF_MONTH_BILLING_EVENT_MONTHS = 10;

    public Payment(LocalDate paymentDate, int paymentAmount) {
        this(
                null,
                null,
                paymentDate,
                paymentAmount
        );
    }

    public Payment(LocalDate previousPaymentDate,
                   Integer previousPaymentAmount,
                   LocalDate paymentDate,
                   Integer paymentAmount) {
        this.previousPaymentDate = previousPaymentDate;
        this.previousPaymentAmount = previousPaymentAmount;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public LocalDate expireDate() {
        if (isExtendSubscription()) {
            int remainingAvailableMonths = monthsAvailable(previousPaymentAmount);
            int addedAvailableMonths = monthsAvailable(paymentAmount);

            return previousPaymentDate.plusMonths(remainingAvailableMonths + addedAvailableMonths);
        }

        return paymentDate.plusMonths(monthsAvailable(paymentAmount));
    }

    private boolean isExtendSubscription() {
        if (previousPaymentDate == null) {
            return false;
        }

        LocalDate previousExpirationDate =
                previousPaymentDate.plusMonths(monthsAvailable(previousPaymentAmount));

        return paymentDate.isBefore(previousExpirationDate) ||
                paymentDate.isEqual(previousExpirationDate);
    }

    private int monthsAvailable(int totalPayAmount) {
        int numberOfMonthsPaid = totalPayAmount / MINIMUM_USAGE_AMOUNT;
        int numberOfEvents = numberOfMonthsPaid / NUMBER_OF_MONTH_BILLING_EVENT_MONTHS;
        int months = numberOfMonthsPaid % NUMBER_OF_MONTH_BILLING_EVENT_MONTHS;

        return (numberOfEvents * 12) + months;
    }
}
