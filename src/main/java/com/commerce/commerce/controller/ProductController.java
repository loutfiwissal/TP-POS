package com.commerce.commerce.controller;

import com.commerce.commerce.dto.ProductDto;
import com.commerce.commerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductDto(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProductDto());
    }
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto created = productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyProduct(@Valid @RequestBody ProductDto productDto,@PathVariable Long id ){
        ProductDto modified=productService.modifyProduct(productDto,id);
        return ResponseEntity.ok(modified);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product is deleted successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllProducts(){
        productService.deleteAllProducts();
        return ResponseEntity.ok("All products are deleted");
    }

}
