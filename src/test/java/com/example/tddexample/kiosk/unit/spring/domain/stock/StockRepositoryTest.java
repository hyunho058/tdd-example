package com.example.tddexample.kiosk.unit.spring.domain.stock;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@Transactional
class StockRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private StockRepository stockRepository;

    @DisplayName("원하는 상품번호를 가진 재고를 조회한다.")
    @Test
    void findAllByProductNumberIn() {
        //given
        Stock stock1 = new Stock("001", 2);
        Stock stock2 = new Stock("002", 10);
        Stock stock3 = new Stock("003", 20);

        stockRepository.saveAll(List.of(stock1, stock2, stock3));
        //when
        List<Stock> stocks = stockRepository.findAllByProductNumberIn(List.of("001", "002"));

        //then
        assertThat(stocks).hasSize(2)
                .extracting("productNumber", "quantity")
                .containsExactlyInAnyOrder(
                        tuple("001", 2),
                        tuple("002", 10)
                );
    }
}
