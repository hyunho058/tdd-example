package com.example.tddexample.kiosk.unit.spring.api.presentation.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.ProductService;
import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/v2/products/new")
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productService.createProduct(request);
    }

    @GetMapping("/api/vi/products/selling")
    public List<ProductResponse> getSellingProducts(){
        return productService.getSellingProducts();
    }
}
