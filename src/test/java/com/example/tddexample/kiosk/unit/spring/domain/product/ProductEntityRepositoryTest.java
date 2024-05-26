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
class ProductEntityRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private ProductJpaRepository productJPARepository;

    @DisplayName("원하는 판매상태를 가진 상품을 조회한다.")
    @Test
    void findAllBySellingStatusIn() {
        //given
        ProductEntity product1 = new ProductEntity(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        ProductEntity product2 = new ProductEntity(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        ProductEntity product3 = new ProductEntity(
            "003",
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productJPARepository.saveAll(List.of(product1, product2, product3));

        //when
        List<ProductEntity> products =
            productJPARepository.findAllBySellingStatusIn(List.of(ProductSellingStatus.SELLING, ProductSellingStatus.HOLD));

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
        ProductEntity product1 = new ProductEntity(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        ProductEntity product2 = new ProductEntity(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        ProductEntity product3 = new ProductEntity(
            "003",
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productJPARepository.saveAll(List.of(product1, product2, product3));

        //when
        List<ProductEntity> products =
            productJPARepository.findAllByProductNumberIn(List.of("001", "002"));

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
        ProductEntity product1 = new ProductEntity(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        ProductEntity product2 = new ProductEntity(
            "002",
            ProductType.HANDMADE,
            ProductSellingStatus.HOLD,
            "카페라뗴",
            4500);
        ProductEntity product3 = new ProductEntity(
            targetProductNumber,
            ProductType.HANDMADE,
            ProductSellingStatus.STOP_SELLING,
            "빙수",
            6000);

        productJPARepository.saveAll(List.of(product1, product2, product3));

        //when
        String latestProductNumber = productJPARepository.findLatestProduct();

        //then
        assertThat(latestProductNumber).isEqualTo(targetProductNumber);
    }

    @DisplayName("가장 마지막으로 저장한 상품의 상품번호를 가져올 때, 상품이 없는 경우 null을 반환")
    @Test
    void findLatestProductNumberWhenProductIsEmpty() {
        //when
        String latestProductNumber = productJPARepository.findLatestProduct();

        //then
        assertThat(latestProductNumber).isNull();
    }
}
