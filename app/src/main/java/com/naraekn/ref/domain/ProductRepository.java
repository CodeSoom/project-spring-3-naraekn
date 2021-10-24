package com.naraekn.ref.domain;

import java.util.List;
import java.util.Optional;

/**
 * 프로덕트 데이터를 다루는 명령을 정의합니다.
 */
public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long id);
}
