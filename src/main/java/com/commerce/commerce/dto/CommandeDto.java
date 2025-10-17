package com.commerce.commerce.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class CommandeDto {
    private long id ;
    private LocalDateTime dateCommande;
    private BigDecimal total;
    private Map<Long, Integer> produitsQuantites = new HashMap<>();

    public CommandeDto() {}
    public CommandeDto(Long id, LocalDateTime dateCommande, BigDecimal total) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.total = total;
    }
    public CommandeDto(Long id, LocalDateTime dateCommande, BigDecimal total, Map<Long, Integer> produitsQuantites) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.total = total;
        this.produitsQuantites = produitsQuantites;
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
