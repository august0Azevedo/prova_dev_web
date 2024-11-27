package com.example.prova.api.persistence.repository;



import com.example.prova.api.persistence.entity.Treino;
import com.example.prova.api.persistence.entity.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    List<Treino> findByStatus(Status status);
}