package com.example.tddexample.kiosk.unit.spring.api.presentation.product;

import com.example.tddexample.kiosk.unit.spring.ControllerTestSupport;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ProductControllerTest extends ControllerTestSupport {

    @DisplayName("신규 상품을 등록한다.")
    @Test
    void createProduct() throws Exception {
        //given
        ProductCreateRequest request =
                new ProductCreateRequest(ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 5000);

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("신규 상품을 등록떄 상품 타입이 필수값이다.")
    @Test
    void createProductWithoutType() throws Exception {
        //given
        ProductCreateRequest request =
                new ProductCreateRequest(
                        null,
                        ProductSellingStatus.SELLING,
                        "아메리카노",
                        5000);

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("상품 타입은 필수입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록떄 상품 상태는 필수값이다.")
    @Test
    void createProductWithoutSellingType() throws Exception {
        //given
        ProductCreateRequest request =
                new ProductCreateRequest(
                        ProductType.HANDMADE,
                        null,
                        "아메리카노",
                        5000);

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("상품 판매상태는 필수입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록떄 상품 이름은 필수값이다.")
    @Test
    void createProductWithoutName() throws Exception {
        //given
        ProductCreateRequest request =
                new ProductCreateRequest(
                        ProductType.HANDMADE,
                        ProductSellingStatus.SELLING,
                        null,
                        5000);

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("상품 이름은 필수입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록떄 상품 가격은 양수여야 합니다.")
    @Test
    void createProductNegativePrice() throws Exception {
        //given
        ProductCreateRequest request =
                new ProductCreateRequest(
                        ProductType.HANDMADE,
                        ProductSellingStatus.SELLING,
                        "아메리카노",
                        -5000);

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("상품 가격은 양수입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty());
    }

    @DisplayName("판매 상품을 조회한다.")
    @Test
    void getSellingProducts() throws Exception {
        //given
        List<ProductResponse> result = List.of();
        Mockito.when(productServiceImpl.getSellingProducts()).thenReturn(result);
        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/vi/products/selling")
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray());
    }

    @DisplayName("상품 단건 조회한다.")
    @Test
    void getProduct() throws Exception {
        //given
        Long id = 1L;
        given(productServiceImpl.getProduct(any(Long.class)))
                .willReturn(new ProductResponse(
                        1L,
                        "001",
                        ProductType.HANDMADE,
                        ProductSellingStatus.SELLING,
                        "아메리카노",
                        4000
                ));

        //when
        //then
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/vi/products/{id}", id)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"));
    }
}
