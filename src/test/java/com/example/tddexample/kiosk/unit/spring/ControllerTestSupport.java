package com.example.tddexample.kiosk.unit.spring;

import com.example.tddexample.kiosk.unit.spring.api.application.order.OrderServiceImpl;
import com.example.tddexample.kiosk.unit.spring.api.application.product.ProductServiceImpl;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.OrderController;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {
        OrderController.class,
        ProductController.class
})
public abstract class ControllerTestSupport {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected ProductServiceImpl productServiceImpl;

    @MockBean
    protected OrderServiceImpl orderServiceImpl;
}
