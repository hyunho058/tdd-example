package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class ProductNumberFactoryTest extends IntegrationTestSupport {
    @Autowired
    private ProductNumberFactory productNumberFactory;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("상품을 등록 할 때 최초 상품 이면 상품 번호 001을 반환 한다.")
    @Test
    void createProductNumberWithoutProduct() {
        //given
        //when
        String productNumber = productNumberFactory.createProductNumber();

        //then
        assertThat(productNumber).isEqualTo("001");
    }

    @DisplayName("이미 등록 되어 있는 상품 번호가 '001' 이면 '002'를 반환 한다.")
    @Test
    void createProductNumber() {
        //given
        Product product = new Product(
                "001",
                ProductType.HANDMADE,
                ProductSellingStatus.SELLING,
                "아메리카노",
                4000);
        productRepository.save(product);

        //when
        String productNumber = productNumberFactory.createProductNumber();

        //then
        assertThat(productNumber).isEqualTo("002");
    }
}
