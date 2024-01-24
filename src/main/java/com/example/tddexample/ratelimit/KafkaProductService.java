package com.example.tddexample.ratelimit;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Slf4j
@Service
public class KafkaProductService {
    private final ProductTestService productService;
    private final Producer<String, String> kafkaProducer;

    public KafkaProductService(ProductTestService productService) {
        this.productService = productService;

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<>(properties);
    }

    //    @KafkaListener(topics = "product", groupId = "productGroup")
//    public void consumeProduct(String productId) {
//        //id 처리 logic
//    }
    @KafkaListener(topics = "yourTopic", groupId = "yourGroup")
    public void consumeProduct(String record, Acknowledgment acknowledgment) {
        try {
            // 메시지 처리 로직
            processMessage(record);
            // 메시지 처리가 성공적으로 완료된 후 Offset 커밋
            acknowledgment.acknowledge();
        } catch (Exception e) {
            log.info("오류 처리 : ",e);
            // 로그 기록, 오류 처리 등
            // Offset 커밋을 하지 않으면 해당 메시지는 다시 처리될 것임
        }
    }

    private void processMessage(String record) {
        // 실제 메시지 처리 로직
        productService.processProduct(record);
    }

    public void sendMessage(String message) {
        kafkaProducer.send(new ProducerRecord<String, String>("test-product","1"));
    }
}
