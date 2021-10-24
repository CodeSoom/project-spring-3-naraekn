package com.naraekn.ref.controllers;

import com.naraekn.ref.application.ProductCommandService;
import com.naraekn.ref.domain.Product;
import com.naraekn.ref.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 프로덕트에 대한 관리자의 HTTP 요청을 처리합니다.
 */
@RestController
@RequestMapping("/products")
public class ProductAdminController {
    private final ProductCommandService productService;

    public ProductAdminController(ProductCommandService productService) {
        this.productService = productService;
    }

    /**
     * 프로덕트를 생성하고 리턴합니다.
     * @param productDto 프로덕트 생성 정보
     * @return 생성된 프로덕트
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}
