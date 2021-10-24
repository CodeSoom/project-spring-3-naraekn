package com.naraekn.ref.application;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductQueryServiceTest {
    private ProductRepository productRepository;
    private ProductQueryService productQueryService;

    private Product productFixture;

    @BeforeEach
    void setup() {
        productRepository = mock(ProductRepository.class);
        productQueryService = new ProductQueryService(productRepository);
    }

    @BeforeEach
    void setupFixtures() {
        productFixture = Product.builder()
                .id(1L)
                .name("오늘의집")
                .code("ohou")
                .category("이커머스")
                .company("버킷플레이스")
                .logoImage("image-url")
                .build();
    }

    @Nested
    @DisplayName("프로덕트 목록 조회")
    class CreateProduct {
        @BeforeEach
        void setup() {
            List list = new ArrayList<Product>();
            list.add(productFixture);

            given(productRepository.findAll()).willReturn(list);
        }

        @Test
        @DisplayName("프로덕트 목록을 반환한다.")
        void saveProductAndReturnIt() {
            var products = productQueryService.getProducts();

            verify(productRepository).findAll();

            assertThat(products.get(0)).isSameAs(productFixture);
        }
    }
}
