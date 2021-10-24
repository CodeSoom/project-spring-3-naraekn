package com.naraekn.ref.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naraekn.ref.TestUtils;
import com.naraekn.ref.domain.Product;
import com.naraekn.ref.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ProductDto productDtoFixture;

    @BeforeEach
    void setUpFixtures() {
        productDtoFixture = ProductDto.builder()
                .name("오늘의집")
                .code("ohou")
                .category("이커머스")
                .company("버킷플레이스")
                .logoImage("image-url")
                .build();
    }

    Product createProductBeforeTest() throws Exception {
        var result = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDtoFixture)));

        return TestUtils.content(result, Product.class);
    }

    @Nested
    @DisplayName("프로덕트 목록 조회")
    class ProductsGet {
        Product product;

        @BeforeEach
        void setupProduct() throws Exception {
            product = createProductBeforeTest();
        }

        @Test
        @DisplayName("프로덕트 목록을 반환한다.")
        void responseWithProducts() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(product.getId().toString())))
                    .andExpect(content().string(containsString(product.getName())))
                    .andExpect(content().string(containsString(product.getCategory())))
                    .andExpect(content().string(containsString(product.getCode())))
                    .andExpect(content().string(containsString(product.getCompany())))
                    .andExpect(content().string(containsString(product.getLogoImage())));
        }
    }
}
