package com.example.tddexample.kiosk.unit.spring.docs.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.ProductServiceImpl;
import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.ProductController;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.docs.RestDocsSupport;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

public class ProductEntityControllerDocsTest extends RestDocsSupport {

    private final ProductServiceImpl productServiceImpl = mock(ProductServiceImpl.class);

    @Override
    protected Object initController() {
        return new ProductController(productServiceImpl);
    }

    @DisplayName("신규 상품을 등록하는 API")
    @Test
    void createProduct() throws Exception {
        ProductCreateRequest request =
                new ProductCreateRequest(
                        ProductType.HANDMADE,
                        ProductSellingStatus.SELLING,
                        "아메리카노",
                        5000
                );

        given(productServiceImpl.createProduct(any(ProductCreateServiceRequest.class)))
                .willReturn(new ProductResponse(
                        1L,
                        "001",
                        ProductType.HANDMADE,
                        ProductSellingStatus.SELLING,
                        "아메리카노",
                        4000
                ));

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v2/products/new")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("product-create",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("type").type(JsonFieldType.STRING)
                                        .description("상품 타입"),
                                fieldWithPath("sellingStatus").type(JsonFieldType.STRING)
                                        .optional()
                                        .description("상품 판매상태"),
                                fieldWithPath("name").type(JsonFieldType.STRING)
                                        .description("상품 이름"),
                                fieldWithPath("price").type(JsonFieldType.NUMBER)
                                        .description("상품 가격")
                        ),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER)
                                        .description("코드"),
                                fieldWithPath("status").type(JsonFieldType.STRING)
                                        .description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING)
                                        .description("메시지"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT)
                                        .description("응답 데이터"),
                                fieldWithPath("data.id").type(JsonFieldType.NUMBER)
                                        .description("상품 ID"),
                                fieldWithPath("data.productNumber").type(JsonFieldType.STRING)
                                        .description("상품 번호"),
                                fieldWithPath("data.type").type(JsonFieldType.STRING)
                                        .description("상품 타입"),
                                fieldWithPath("data.sellingStatus").type(JsonFieldType.STRING)
                                        .description("상품 판매상태"),
                                fieldWithPath("data.name").type(JsonFieldType.STRING)
                                        .description("상품 이름"),
                                fieldWithPath("data.price").type(JsonFieldType.NUMBER)
                                        .description("상품 가격")
                        )
                ));
    }

    @DisplayName("판매 상품을 조회하는 API")
    @Test
    void getSellingProducts() throws Exception {
        List<ProductResponse> result = List.of();
        Mockito.when(productServiceImpl.getSellingProducts()).thenReturn(result);

        given(productServiceImpl.getSellingProducts())
                .willReturn(List.of(
                        new ProductResponse(
                                1L,
                                "001",
                                ProductType.HANDMADE,
                                ProductSellingStatus.SELLING,
                                "아메리카노",
                                4000
                        )));

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/vi/products/selling")
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andDo(document("product-get-list",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER)
                                        .description("코드"),
                                fieldWithPath("status").type(JsonFieldType.STRING)
                                        .description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING)
                                        .description("메시지"),
                                fieldWithPath("data").type(JsonFieldType.ARRAY)
                                        .description("응답 데이터"),
                                fieldWithPath("data[].id").type(JsonFieldType.NUMBER)
                                        .description("상품 ID"),
                                fieldWithPath("data[].productNumber").type(JsonFieldType.STRING)
                                        .description("상품 번호"),
                                fieldWithPath("data[].type").type(JsonFieldType.STRING)
                                        .description("상품 타입"),
                                fieldWithPath("data[].sellingStatus").type(JsonFieldType.STRING)
                                        .description("상품 판매상태"),
                                fieldWithPath("data[].name").type(JsonFieldType.STRING)
                                        .description("상품 이름"),
                                fieldWithPath("data[].price").type(JsonFieldType.NUMBER)
                                        .description("상품 가격")
                        )
                ));
    }

    @DisplayName("상품 단건 조회 API")
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
                        RestDocumentationRequestBuilders.get("/api/vi/products/{id}", id) //pathParameters를 사용할거면 MockMvcBuilders 보다 RestDocumentationRequestBuilders를 이용하는 것이 좋다고 한다.
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"))
                .andDo(document("product-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("id").description("상품 ID")
                        ),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER)
                                        .description("코드"),
                                fieldWithPath("status").type(JsonFieldType.STRING)
                                        .description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING)
                                        .description("메시지"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT)
                                        .description("응답 데이터"),
                                fieldWithPath("data.id").type(JsonFieldType.NUMBER)
                                        .description("상품 ID"),
                                fieldWithPath("data.productNumber").type(JsonFieldType.STRING)
                                        .description("상품 번호"),
                                fieldWithPath("data.type").type(JsonFieldType.STRING)
                                        .description("상품 타입"),
                                fieldWithPath("data.sellingStatus").type(JsonFieldType.STRING)
                                        .description("상품 판매상태"),
                                fieldWithPath("data.name").type(JsonFieldType.STRING)
                                        .description("상품 이름"),
                                fieldWithPath("data.price").type(JsonFieldType.NUMBER)
                                        .description("상품 가격")
                        )
                ));
    }
}
