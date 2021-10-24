package com.naraekn.ref.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductAdminControllerTest {
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

    @Nested
    @DisplayName("프로덕트 생성")
    class ProductPost {
        @Test
        @DisplayName("프로덕트를 저장하고 반환한다.")
        void saveProductAndReturnIt() throws Exception {
            mockMvc.perform(post("/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productDtoFixture)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.name", is("오늘의집")))
                    .andExpect(jsonPath("$.code", is("ohou")))
                    .andExpect(jsonPath("$.category", is("이커머스")))
                    .andExpect(jsonPath("$.company", is("버킷플레이스")))
                    .andExpect(jsonPath("$.logoImage", is("image-url")));
        }
    }
}
