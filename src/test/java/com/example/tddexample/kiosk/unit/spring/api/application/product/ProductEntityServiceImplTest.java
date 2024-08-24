package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.infrastructure.order.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@Transactional
class ProductEntityServiceImplTest extends IntegrationTestSupport {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductJpaRepository productJPARepository;

    @DisplayName("가장 최근 등록된 상품 번호에 1증가된 상품번호로 신규 상품을 등록한다.")
    @Test
    void createProduct() {
        //given
        ProductEntity product = new ProductEntity(
            "001",
            ProductType.HANDMADE,
            ProductSellingStatus.SELLING,
            "아메리카노",
            4000);
        productJPARepository.save(product);

        ProductCreateRequest request =
            new ProductCreateRequest(
                ProductType.HANDMADE,
                ProductSellingStatus.SELLING,
                "카푸치노",
                5000
            );
        //when
        ProductResponse productResponse = productServiceImpl.createProduct(request.toServiceRequest());

        //then
        assertThat(productResponse)
            .extracting("productNumber", "type", "sellingStatus", "name", "price")
            .contains("002", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000);

        List<ProductEntity> products = productJPARepository.findAll();
        assertThat(products).hasSize(2)
            .extracting("productNumber", "type", "sellingStatus", "name", "price")
            .containsExactlyInAnyOrder(
                tuple("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 4000),
                tuple("002", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000)
            );
    }

    @DisplayName("등록된 상품이 없을 경우 상품을 등록하면 상품 번호는 001이다.")
    @Test
    void createProductWhenProductsIsEmpty() {
        //given
        ProductCreateRequest request =
            new ProductCreateRequest(
                ProductType.HANDMADE,
                ProductSellingStatus.SELLING,
                "카푸치노",
                5000
            );
        //when
        ProductResponse productResponse = productServiceImpl.createProduct(request.toServiceRequest());

        //then
        assertThat(productResponse)
            .extracting("productNumber", "type", "sellingStatus", "name", "price")
            .contains("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000);

        List<ProductEntity> products = productJPARepository.findAll();
        assertThat(products).hasSize(1)
            .extracting("productNumber", "type", "sellingStatus", "name", "price")
            .containsExactlyInAnyOrder(
                tuple("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000)
            );
    }

    @DisplayName("상품 정보를 조회 한다.")
    @Test
    void getProduct() {
        //given
        ProductEntity newProduct = new ProductEntity(
                "001",
                ProductType.HANDMADE,
                ProductSellingStatus.SELLING,
                "아메리카노",
                4000);
        ProductEntity savedProduct = productJPARepository.save(newProduct);

        Long savedProductId = savedProduct.getId();

        //when
        ProductResponse retrievedProduct = productServiceImpl.getProduct(savedProductId);

        //then
        assertThat(retrievedProduct)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .contains("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 4000);
    }
}
