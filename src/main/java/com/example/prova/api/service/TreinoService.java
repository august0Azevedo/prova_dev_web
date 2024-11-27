package com.example.prova.api.service;


import com.example.prova.api.entity.Treino;
import com.example.prova.api.entity.StatusTreino;
import com.example.prova.api.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public Treino criarTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Optional<Treino> buscarTreinoPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<Treino> buscarTreinosPorStatus(StatusTreino status) {
        return treinoRepository.findByStatus(status);
    }

    public Treino atualizarTreino(Long id, Treino treinoAtualizado) {
        if (treinoRepository.existsById(id)) {
            treinoAtualizado.setId(id);
            return treinoRepository.save(treinoAtualizado);
        }
        return null;
    }

    public void deletarTreino(Long id) {
        treinoRepository.deleteById(id);
    }

    public Treino atualizarStatusTreino(Long id, StatusTreino novoStatus) {
        Optional<Treino> treinoOptional = treinoRepository.findById(id);
        if (treinoOptional.isPresent()) {
            Treino treino = treinoOptional.get();
            treino.setStatus(novoStatus);
            return treinoRepository.save(treino);
        }
        return null;
    }
}