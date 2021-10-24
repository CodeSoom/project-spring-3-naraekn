package com.naraekn.ref.application;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.domain.ProductRepository;
import com.naraekn.ref.dto.ProductDto;
import com.naraekn.ref.mappers.ProductMapper;
import org.springframework.stereotype.Service;

/**
 * 프로덕트를 생성하는 기능을 제공합니다.
 */
@Service
public class ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 프로덕트를 생성하고 리턴합니다.
     * @param productDto 프로덕트 생성 데이터
     * @return 생성된 프로덕트
     */
    public Product createProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        return productRepository.save(product);
    }
}
