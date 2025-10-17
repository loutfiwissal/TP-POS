package com.commerce.commerce.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_commande", nullable = false)
    private LocalDateTime dateCommande;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
    @ElementCollection
    @CollectionTable(name = "commande_produits", joinColumns = @JoinColumn(name = "commande_id"))
    @MapKeyColumn(name = "produit_id")
    @Column(name = "quantite")
    private Map<Long, Integer> produitsQuantites = new HashMap<>();

    public Commande() {
        this.dateCommande = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
    }
    public Commande(Map<Long, Integer> produitsQuantites) {
        this();
        this.produitsQuantites = produitsQuantites;
    }
    public void ajouterProduit(Long produitId, Integer quantite) {
        this.produitsQuantites.put(produitId, quantite);
    }

    public void supprimerProduit(Long produitId) {
        this.produitsQuantites.remove(produitId);
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDateTime dateCommande) { this.dateCommande = dateCommande; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Map<Long, Integer> getProduitsQuantites() { return produitsQuantites; }
    public void setProduitsQuantites(Map<Long, Integer> produitsQuantites) {
        this.produitsQuantites = produitsQuantites;
    }
}
