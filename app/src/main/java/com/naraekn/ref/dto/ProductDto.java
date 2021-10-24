package com.naraekn.ref.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ProductDto {
    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotBlank
    private String company;

    @NotBlank
    private String category;

    private String logoImage;

    @Builder
    public ProductDto(
            String name,
            String code,
            String company,
            String category,
            String logoImage
    ) {
        this.name = name;
        this.code = code;
        this.company = company;
        this.category = category;
        this.logoImage = logoImage;
    }
}
