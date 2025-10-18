package com.commerce.commerce.dto;

import com.commerce.commerce.model.Category;
import jakarta.persistence.*;

public class ProductDto {
    private String name;
    private double price;
    private Category category;
    public ProductDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
