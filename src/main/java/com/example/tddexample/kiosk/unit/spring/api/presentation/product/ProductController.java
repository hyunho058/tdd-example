package com.example.tddexample.kiosk.unit.spring.api.presentation.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.ProductService;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.comon.dto.ApiResponse;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        return new ApiResponse<>(
                HttpStatus.CREATED,
                productService.createProduct(request.toServiceRequest()));
    }

    @GetMapping("/api/vi/products/selling")
    public ApiResponse<List<ProductResponse>> getSellingProducts(){
        return new ApiResponse<>(
                HttpStatus.OK,
                productService.getSellingProducts()
        );
    }
}
