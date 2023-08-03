package com.example.tddexample.kiosk.unit.spring.api.presentation.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.ProductService;
import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/vi/products/selling")
    public List<ProductResponse> getSellingProducts(){
        return productService.getSellingProducts();
    }
}
