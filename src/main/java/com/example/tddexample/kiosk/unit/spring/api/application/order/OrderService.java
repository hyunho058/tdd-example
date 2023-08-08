package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Products;
import com.example.tddexample.kiosk.unit.spring.domain.stock.Stock;
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
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Transactional
    public OrderResponse createOrder(OrderCreateServiceRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.productNumbers();
        Products products = new Products(productRepository.findAllByProductNumberIn(productNumbers));

        List<String> stockProductNumbers = products.containProductNumberType();

        List<Stock> stocks = stockRepository.findAllByProductNumberIn(stockProductNumbers);
        Map<String, Stock> stockMap =
                stocks.stream()
                        .collect(Collectors.toMap(Stock::getProductNumber, s -> s));

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
            Stock stock = stockMap.get(productNumber);
            int quantity = productCountingMap.get(productNumber);

            stock.reduceQuantity(quantity);
        }

        List<Product> duplicateProducts = products.productsWithDuplicates(productNumbers);

        Order newOrder = new Order(duplicateProducts, registeredDateTime);
        Order savedOrder = orderRepository.save(newOrder);

        return new OrderResponse(savedOrder, duplicateProducts);
    }
}
