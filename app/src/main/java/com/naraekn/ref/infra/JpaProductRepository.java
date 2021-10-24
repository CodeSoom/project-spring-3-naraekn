package com.naraekn.ref.infra;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.domain.ProductRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaProductRepository
        extends ProductRepository, CrudRepository<Product, Long>{
    List<Product> findAll();

    Product save(Product product);
}
