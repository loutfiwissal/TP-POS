package com.commerce.commerce.repository;

import com.commerce.commerce.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateCommandeBetween(LocalDateTime start, LocalDateTime end);
}
