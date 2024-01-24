package com.example.tddexample.ratelimit;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductTestService {
    private final RateLimiter rateLimiter;
    private final RestTemplate restTemplate;

    public ProductTestService(RateLimiter rateLimiter, RestTemplateBuilder restTemplateBuilder) {
        this.rateLimiter = rateLimiter;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void processProduct(String productId) {
        if (rateLimiter.allowRequest("product_request")) {
            // API 호출
            fetchProductInfo(productId);
        } else {
            // 요청 거부 또는 지연 처리
        }
    }

    private void fetchProductInfo(String productId) {
        // 외부 API 호출
        try {
            String url = "http://external.api/products/" + productId;
            // RestTemplate을 사용하여 외부 API 호출
        } catch (HttpClientErrorException.TooManyRequests e) {
            // 재시도 로직 또는 대기 후 재시도
        }
    }
}
