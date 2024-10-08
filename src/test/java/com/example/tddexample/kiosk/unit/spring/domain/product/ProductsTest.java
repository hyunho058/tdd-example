package com.example.tddexample.kiosk.unit.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductsTest {
    @DisplayName("재고 확인이 필요한 타입 상품 목록 필터")
    @Test
    void containProductNumberType() {
        //given
        Product product1 = createProduct("001", ProductType.BOTTLE, 4000);
        Product product2 = createProduct("002", ProductType.BAKERY, 4500);
        Product product3 = createProduct("003", ProductType.HANDMADE, 5000);
        List<Product> products = List.of(product1, product2, product3);

        Products orderProducts = new Products(products);

        //when
        List<String> productNumbers = orderProducts.containProductNumberType();

        //then
        assertThat(productNumbers).hasSize(2);
    }

    private Product createProduct(String productNumber, ProductType type, int price) {
        return Product.create(
                productNumber,
                type,
                ProductSellingStatus.SELLING,
                "상품 이름",
                price
        );
    }
}
