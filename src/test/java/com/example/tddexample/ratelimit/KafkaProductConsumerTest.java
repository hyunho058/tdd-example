package com.example.tddexample.ratelimit;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class KafkaProductConsumerTest extends IntegrationTestSupport {
    @Autowired
    KafkaProductConsumer kafkaProductConsumer;

    @Test
    void test() {
        for (int i = 0; i < 20; i++) {
            kafkaProductConsumer.sendMessage(String.valueOf(i));
        }
    }
}
