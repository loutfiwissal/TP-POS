package com.commerce.commerce.service;

import com.commerce.commerce.dto.ProductDto;
import com.commerce.commerce.exception.ProductNotFoundException;
import com.commerce.commerce.model.Product;
import com.commerce.commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No product with this ID."));
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductDto> getAllProductDto() {
        List<Product> products = getAllProducts();
        List<ProductDto> dtos = new ArrayList<>();
        for (Product p : products) {
            dtos.add(convertToDto(p));
        }
        return dtos;
    }

    public ProductDto getProductDto(long id){
        Product product=getProduct(id);
        return convertToDto(product);
    }
    public ProductDto addProduct(ProductDto productdto){

        Product product=new Product();
        product.setName(productdto.getName());
        product.setCategory(productdto.getCategory());
        product.setPrice(productdto.getPrice());
        productRepository.save(product);
        return productdto;
    }
    public void deleteProduct(long id){
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("No product with this ID.");
        }
        productRepository.deleteById(id);
    }

    public ProductDto modifyProduct(ProductDto productDto, long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No product with this ID."));

        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());

        return convertToDto(productRepository.save(product));
    }
    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
