package com.commerce.commerce.dto;

import com.commerce.commerce.model.Category;
import jakarta.validation.constraints.NotBlank;

public class CreateProductDto {
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotBlank(message = "Price must be greater than 0 and not empty")
    private double price;
    @NotBlank(message = "Category must be selected")
    private Category category;
    public @NotBlank(message = "Name must not be empty") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name must not be empty") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Price must be greater than 0 and not empty") double getPrice() {
        return price;
    }

    public void setPrice(@NotBlank(message = "Price must be greater than 0 and not empty") double price) {
        this.price = price;
    }

    public @NotBlank(message = "Category must be selected") Category getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category must be selected") Category category) {
        this.category = category;
    }
}
