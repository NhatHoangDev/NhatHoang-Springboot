package com.example.dtospringboot.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductAPI {
    private final ProductService productService;
    private final IProductMapper mapper;

    /*@PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO){
        productService.save(mapper.toProduct(productDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }*/
    /*@PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO){
        Optional<Product> productOptional = productService.findById(mapper.toProduct(productDTO).getId());
        if (!productOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Product product = mapper.toProduct(productDTO);
        product.setId(id);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }*/
    /*@DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete(@Valid @PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        productService.removeById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }*/
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(mapper.toProductDtos(productService.findAll()));
    }
   /* @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@Valid @PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(mapper.toProductDto(productOptional.get()));
    }*/
}
