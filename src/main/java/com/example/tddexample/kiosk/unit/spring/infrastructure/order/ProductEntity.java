package com.example.tddexample.kiosk.unit.spring.infrastructure.order;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "product")
@Entity
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    protected ProductEntity() {
    }

    public ProductEntity(
            String productNumber,
            ProductType type,
            ProductSellingStatus sellingStatus,
            String name,
            int price
    ) {
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }

    public static ProductEntity fromModel(Product product) {
        return new ProductEntity(product.getProductNumber(),
                product.getType(),
                product.getSellingStatus(),
                product.getName(),
                product.getPrice());
    }

    public Product toModel() {
        return Product.create(
                productNumber,
                type,
                sellingStatus,
                name,
                price
        );
    }
}
