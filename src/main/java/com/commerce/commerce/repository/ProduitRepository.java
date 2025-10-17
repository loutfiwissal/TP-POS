package com.commerce.commerce.repository;

import com.commerce.commerce.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> getByCategory();
}
