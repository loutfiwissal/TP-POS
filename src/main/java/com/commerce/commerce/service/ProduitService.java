package com.commerce.commerce.service;

import com.commerce.commerce.dto.ProduitDto;
import com.commerce.commerce.exception.InvalidProductInfo;
import com.commerce.commerce.exception.ProductNotFound;
import com.commerce.commerce.model.Produit;
import com.commerce.commerce.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit getProduct(long id){
        return produitRepository.findById(id).orElseThrow(() -> new ProductNotFound("Aucun Produit avec cet id"));
    }
    public ProduitDto getProduitDto(long id){
        Produit produit=getProduct(id);
        ProduitDto dto=new ProduitDto();
        dto.setPrix(produit.getPrix());
        dto.setCategory(produit.getCategory());
        dto.setNomProduit(produit.getNomProduit());
        return dto;
    }
    public ProduitDto ajouterProduit(Produit produit){

        if(produit.getNomProduit() == null || produit.getNomProduit().trim().isEmpty())
            throw new InvalidProductInfo("Le nom du produit est obligatoire.");
        if(produit.getCategory() == null)
            throw new InvalidProductInfo("Categorie du produit est obligatoire.");
        produitRepository.save(produit);
        return getProduitDto(produit.getIdProduit());
    }
}
