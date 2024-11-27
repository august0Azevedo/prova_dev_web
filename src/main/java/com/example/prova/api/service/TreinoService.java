package com.example.prova.api.service;



import com.example.prova.api.persistence.entity.Treino;
import com.example.prova.api.persistence.entity.Status;
import com.example.prova.api.persistence.repository.TreinoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public Treino salvarTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Optional<Treino> atualizarTreino(Long id, Treino treinoAtualizado) {
        return treinoRepository.findById(id)
                .map(t -> {
                    t.setNumeroSeries(treinoAtualizado.getNumeroSeries());
                    t.setRepeticoes(treinoAtualizado.getRepeticoes());
                    t.setDescanso(treinoAtualizado.getDescanso());
                    t.setStatus(treinoAtualizado.getStatus());
                    return treinoRepository.save(t);
                });
    }

    public void excluirTreino(Long id) {
        treinoRepository.deleteById(id);
    }

    public List<Treino> buscarTreinosPorStatus(Status status) {
        return treinoRepository.findByStatus(status);
    }
}