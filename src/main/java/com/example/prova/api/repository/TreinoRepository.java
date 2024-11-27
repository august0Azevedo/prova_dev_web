package com.example.prova.api.repository;

import com.example.prova.api.entity.Treino;
import com.example.prova.api.entity.StatusTreino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    List<Treino> findByStatus(StatusTreino status);
}