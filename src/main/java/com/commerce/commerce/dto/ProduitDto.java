package com.commerce.commerce.dto;

import com.commerce.commerce.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ProduitDto {
    private String nomProduit;
    private double prix;
    private Category category;
    public ProduitDto() {}
    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
