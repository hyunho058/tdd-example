package com.example.tddexample.kiosk.unit.spring.api.presentation.order;

import com.example.tddexample.kiosk.unit.spring.ControllerTestSupport;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.request.OrderCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest extends ControllerTestSupport {

    @DisplayName("주문을 등록한다.")
    @Test
    void createOrder() throws Exception {
        //given
        OrderCreateRequest request =
                new OrderCreateRequest(List.of("001"));

        //when
        //then
        mockMvc.perform(
                        post("/api/v1/orders/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"));;
    }

    @DisplayName("주문을 등록할때 상품번호 목록은 필수 입니다.")
    @Test
    void createOrderWithoutProductNumbers() throws Exception {
        //given
        OrderCreateRequest request =
                new OrderCreateRequest(null);

        //when
        //then
        mockMvc.perform(
                        post("/api/v1/orders/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("상품 번호 리스트는 필수입니다."));;
    }
}
