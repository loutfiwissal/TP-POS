package com.commerce.commerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    @Column(nullable = false, length = 50)
    private String nomProduit;
    @Column(nullable = false)
    private double prix;
    @Enumerated(EnumType.STRING)
    private Category category;

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

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
