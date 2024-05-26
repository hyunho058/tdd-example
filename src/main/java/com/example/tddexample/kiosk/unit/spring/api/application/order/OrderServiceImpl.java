package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Products;
import com.example.tddexample.kiosk.unit.spring.domain.stock.StockEntity;
import com.example.tddexample.kiosk.unit.spring.domain.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderJpaRepository orderJpaRepository;
    private final ProductJpaRepository productJPARepository;
    private final StockRepository stockRepository;

    @Transactional
    @Override
    public OrderResponse createOrder(OrderCreateServiceRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.productNumbers();
        Products products = new Products(productJPARepository.findAllByProductNumberIn(productNumbers));

        List<String> stockProductNumbers = products.containProductNumberType();

        List<StockEntity> stocks = stockRepository.findAllByProductNumberIn(stockProductNumbers);
        Map<String, StockEntity> stockMap =
                stocks.stream()
                        .collect(Collectors.toMap(StockEntity::getProductNumber, s -> s));

//        Map<String, Long> productCountingMap = stockProductNumbers.stream()
//                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        Map<String, Integer> productCountingMap = new HashMap<>();
        for (String productNumber : productNumbers) {
            productCountingMap.put(
                    productNumber,
                    productCountingMap.getOrDefault(productNumber, 0) + 1
            );
        }

        for (String productNumber : stockProductNumbers){
            StockEntity stock = stockMap.get(productNumber);
            int quantity = productCountingMap.get(productNumber);

            stock.reduceQuantity(quantity);
        }

        List<ProductEntity> duplicateProducts = products.productsWithDuplicates(productNumbers);

        OrderEntity newOrder = new OrderEntity(duplicateProducts, registeredDateTime);
        OrderEntity savedOrder = orderJpaRepository.save(newOrder);

        return new OrderResponse(savedOrder, duplicateProducts);
    }
}
