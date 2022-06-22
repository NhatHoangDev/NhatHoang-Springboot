package com.example.dtospringboot.product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IProductMapper {
    ProductDTO toProductDto(Product product);

    List<ProductDTO> toProductDtos(List<Product> products);

    Product toProduct(ProductDTO productDTO);
}
