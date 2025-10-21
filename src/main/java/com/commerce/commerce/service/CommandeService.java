package com.commerce.commerce.service;

import com.commerce.commerce.model.Commande;
import com.commerce.commerce.model.Produit;
import com.commerce.commerce.dto.CommandeDto;
import com.commerce.commerce.dto.CreationCommandeDto;
import com.commerce.commerce.repository.CommandeRepository;
import com.commerce.commerce.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;

    public CommandeDto creerCommande(CreationCommandeDto creationCommandeDto) {
        List<Produit> produits = produitRepository.findAllById(creationCommandeDto.getProduitIds());

        if (produits.isEmpty()) {
            throw new RuntimeException("Aucun produit trouvé pour créer la commande");
        }

        Double total = produits.stream()
                .mapToDouble(Produit::getPrix)
                .sum();

        Commande commande = new Commande();
        commande.setProduits(produits);
        commande.setTotal(total);

        Commande savedCommande = commandeRepository.save(commande);
        return convertToDto(savedCommande);
    }

    public List<CommandeDto> getHistoriqueCommandes() {
        return commandeRepository.findAllByOrderByDateCreationDesc()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CommandeDto convertToDto(Commande commande) {
        CommandeDto dto = new CommandeDto();
        dto.setId(commande.getId());
        dto.setDateCreation(commande.getDateCreation());
        dto.setTotal(commande.getTotal());
        // Convert products to DTOs if needed
        return dto;
    }
}