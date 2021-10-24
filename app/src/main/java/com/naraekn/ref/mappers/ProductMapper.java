package com.naraekn.ref.mappers;

import com.naraekn.ref.domain.Product;
import com.naraekn.ref.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productDtoToProduct(ProductDto product);
}
