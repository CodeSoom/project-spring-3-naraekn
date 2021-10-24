package com.naraekn.ref.application;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.domain.ProductRepository;
import com.naraekn.ref.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductCommandServiceTest {
    private ProductRepository productRepository;
    private ProductCommandService productCommandService;

    private ProductDto productDtoFixture;
    private Product productFixture;

    @BeforeEach
    void setupInstance() {
        productRepository = mock(ProductRepository.class);
        productCommandService = new ProductCommandService(productRepository);
    }

    @BeforeEach
    void setupFixtures() {
        productDtoFixture = ProductDto.builder()
                .name("오늘의집")
                .code("ohou")
                .category("이커머스")
                .company("버킷플레이스")
                .logoImage("image-url")
                .build();

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
    @DisplayName("프로덕트 생성")
    class CreateProduct {
        @BeforeEach
        void setupMocks() {
            given(productRepository.save(any(Product.class)))
                    .willReturn(productFixture);
        }

        @Test
        @DisplayName("프로덕트를 생성하고 반환한다.")
        void createProductAndReturnIt() {
            var product = productCommandService.createProduct(productDtoFixture);

            verify(productRepository).save(any(Product.class));

            assertThat(product).isSameAs(productFixture);
        }
    }
}
