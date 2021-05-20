package com.hellokoding.springboot.restful.product;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    @Override
    public List<ProductDTO> toProductDTOs(List<Product> products) {
        if (products == null) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>(products.size());
        for (Product product : products) {
            list.add(toProductDTO(product));
        }

        return list;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        return product;
    }
}
