package com.example.tddexample.ratelimit;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "test-topic";
    private static final String TOPIC_BYTE = "test-byte-topic";
    private final KafkaTemplate<String, byte[]> byteKafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public void sendMessage(TestData testData) {
        log.info("Produce message");

        try {
            kafkaTemplate.send(testData.getTopic(), gson.toJson(testData));
        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage(), e);
        }
        log.info("send success");
    }

    //    public void sendByteMessage(TestData testData) {
//        log.info("Byte Produce message");
//
//        try {
//            byteKafkaTemplate.send(TOPIC_BYTE, GzipUtil.compress(gson.toJson(testData)));
//        } catch (Exception e) {
//            log.error("Byte Exception : {}",e.getMessage(), e);
//        }
//        log.info("byte send success");
//    }
    static class TestData implements Serializable {

        private String topic;
        private String message;
        private String localDateTime;

        public TestData() {
        }

        public TestData(String topic, String message) {
            this.topic = topic;
            this.message = message;
        }

        public String getTopic() {
            return topic;
        }

        public String getMessage() {
            return message;
        }

        public String getLocalDateTime() {
            return localDateTime;
        }

        public void set() {
            localDateTime = LocalDateTime.now().toString();
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "topic='" + topic + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}


