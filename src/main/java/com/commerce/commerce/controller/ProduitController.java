package com.commerce.commerce.controller;

import com.commerce.commerce.dto.ProduitDto;
import com.commerce.commerce.model.Produit;
import com.commerce.commerce.repository.ProduitRepository;
import com.commerce.commerce.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduitDto(id));
    }
    @PostMapping
    public ResponseEntity<ProduitDto> createStudent(@Valid @RequestBody Produit produit) {
        ProduitDto created = produitService.ajouterProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
