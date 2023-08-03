package com.example.tddexample.kiosk.unit.spring.domain.product;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
    //@DataJpaTest //@SpringBootTest 보다 가볍다,
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @DisplayName("원하는 판매상태를 가진 상품을 조회한다.")
    @Test
    void findAllBySellingStatusIn() {
        //give
        Product product1 = new Product("1", ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 4000);
        Product product2 = new Product("2", ProductType.HANDMADE, ProductSellingStatus.HOLD, "카페라뗴", 4500);
        Product product3 = new Product("3", ProductType.HANDMADE, ProductSellingStatus.STOP_SELLING, "빙수", 6000);

        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        List<Product> products =
            productRepository.findAllBySellingStatusIn(List.of(ProductSellingStatus.SELLING, ProductSellingStatus.HOLD));

        //then
        Assertions.assertThat(products).hasSize(2)
            .extracting("productNumber", "name", "sellingStatus")
            .containsExactlyInAnyOrder(
                Tuple.tuple("1", "아메리카노", ProductSellingStatus.SELLING),
                Tuple.tuple("2", "카페라뗴", ProductSellingStatus.HOLD)
            );
    }
}