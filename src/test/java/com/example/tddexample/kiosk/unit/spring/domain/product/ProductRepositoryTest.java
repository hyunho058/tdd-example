package com.example.tddexample.kiosk.unit.spring.domain.product;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

//@ActiveProfiles("test")
//@SpringBootTest
//@DataJpaTest //@SpringBootTest 보다 가볍다,
@Transactional
class ProductRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private ProductRepository productRepository;

    @DisplayName("원하는 판매상태를 가진 상품을 조회한다.")
    @Test
    void findAllBySellingStatusIn() {
        //given
        Product product1 = new Product(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        Product product2 = new Product(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        Product product3 = new Product(
            "003",
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        List<Product> products =
            productRepository.findAllBySellingStatusIn(List.of(ProductSellingStatus.SELLING, ProductSellingStatus.HOLD));

        //then
        assertThat(products).hasSize(2)
            .extracting("productNumber", "name", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("001", "아메리카노", ProductSellingStatus.SELLING),
                tuple("002", "카페라뗴", ProductSellingStatus.HOLD)
            );
    }

    @DisplayName("상품번호 리스트로 상품을 조회한다.")
    @Test
    void findAllByProductNumberIn() {
        //given
        Product product1 = new Product(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        Product product2 = new Product(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        Product product3 = new Product(
            "003",
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        List<Product> products =
            productRepository.findAllByProductNumberIn(List.of("001", "002"));

        //then
        assertThat(products).hasSize(2)
            .extracting("productNumber", "name", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("001", "아메리카노", ProductSellingStatus.SELLING),
                tuple("002", "카페라뗴", ProductSellingStatus.HOLD)
            );
    }

    @DisplayName("가장 마지막으로 저장한 상품의 상품번호를 가져온다.")
    @Test
    void findLatestProductNumber() {
        //given
        String targetProductNumber = "003";
        Product product1 = new Product(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        Product product2 = new Product(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        Product product3 = new Product(
            targetProductNumber,
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        String latestProductNumber = productRepository.findLatestProduct();

        //then
        assertThat(latestProductNumber).isEqualTo(targetProductNumber);
    }

    @DisplayName("가장 마지막으로 저장한 상품의 상품번호를 가져올 때, 상품이 없는 경우 null을 반환")
    @Test
    void findLatestProductNumberWhenProductIsEmpty() {
        //when
        String latestProductNumber = productRepository.findLatestProduct();

        //then
        assertThat(latestProductNumber).isNull();
    }
}
