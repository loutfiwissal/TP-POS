package com.commerce.commerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDto {
    private Long id;
    private LocalDateTime dateCreation;
    private Double total;
    private List<ProduitDto> produits;
}