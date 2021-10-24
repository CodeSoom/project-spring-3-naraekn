package com.naraekn.ref.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 프로덕트 정보를 저장하고 처리합니다.
 */
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String code;

    private String company;

    private String category;

    private String logoImage;

    public Product() {}

    @Builder
    public Product(Long id, String code, String name, String company, String category, String logoImage) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.company = company;
        this.category = category;
        this.logoImage = logoImage;
    }
}
