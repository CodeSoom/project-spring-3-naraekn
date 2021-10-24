package com.naraekn.ref.application;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 프로덕트 조회 기능을 제공합니다.
 */
@Service
public class ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 프로덕트 목록을 리턴합니다.
     * @return 프로덕트 목록
     */
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
