package com.commerce.commerce.controller;

import com.commerce.commerce.dto.CommandeDto;
import com.commerce.commerce.dto.CreationCommandeDto;
import com.commerce.commerce.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping
    public ResponseEntity<CommandeDto> creerCommande(@RequestBody CreationCommandeDto creationCommandeDto) {
        CommandeDto nouvelleCommande = commandeService.creerCommande(creationCommandeDto);
        return ResponseEntity.ok(nouvelleCommande);
    }

    @GetMapping("/historique")
    public ResponseEntity<List<CommandeDto>> getHistoriqueCommandes() {
        List<CommandeDto> historique = commandeService.getHistoriqueCommandes();
        return ResponseEntity.ok(historique);
    }
}