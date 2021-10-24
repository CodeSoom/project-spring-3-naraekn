package com.naraekn.ref.controllers;

import com.naraekn.ref.application.ProductQueryService;
import com.naraekn.ref.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 프로덕트에 대한 일반 사용자의 HTTP 요청을 처리합니다.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductQueryService productService;

    public ProductController(ProductQueryService productService) {
        this.productService = productService;
    }

    /**
     * 프로덕트 목록을 리턴합니다.
     * @return 프로덕트 목록
     */
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
