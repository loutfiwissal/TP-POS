package com.commerce.commerce.dto;
import java.util.Map;
public class CreationCommandeDto {
    private Map<Long, Integer> produitsQuantites;

    public CreationCommandeDto(){}

    public CreationCommandeDto(Map<Long, Integer> produitsQuantites){
        this.produitsQuantites=produitsQuantites;
    }
    public Map<Long, Integer> getProduitsQuantites() {
        return produitsQuantites;
    }
    public void setProduitsQuantites(Map<Long, Integer> produitsQuantites) {
        this.produitsQuantites = produitsQuantites;
    }

}
