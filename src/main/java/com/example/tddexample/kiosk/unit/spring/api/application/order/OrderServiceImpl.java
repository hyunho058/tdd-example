package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.application.order.port.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.api.application.product.port.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.OrderService;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
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
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Transactional
    @Override
    public OrderResponse createOrder(OrderCreateServiceRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.productNumbers();
        Products products = new Products(productRepository.findAllByProductNumberIn(productNumbers));

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

        List<Product> duplicateProducts = products.productsWithDuplicates(productNumbers);

        Order newOrder = new Order(duplicateProducts, registeredDateTime);
        Order savedOrder = orderRepository.save(newOrder);

        return new OrderResponse(savedOrder, duplicateProducts);
    }
}
