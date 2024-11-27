package com.example.prova.api.controller;


import com.example.prova.api.persistence.entity.Treino;
import com.example.prova.api.persistence.entity.Status;
import com.example.prova.api.service.TreinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public ResponseEntity<Treino> criarTreino(@RequestBody Treino treino) {
        Treino novoTreino = treinoService.salvarTreino(treino);
        return ResponseEntity.ok(novoTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizarTreino(@PathVariable Long id, @RequestBody Treino treinoAtualizado) {
        Optional<Treino> treino = treinoService.atualizarTreino(id, treinoAtualizado);
        return treino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTreino(@PathVariable Long id) {
        treinoService.excluirTreino(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Treino>> listarTreinosPorStatus(@RequestParam Status status) {
        List<Treino> treinos = treinoService.buscarTreinosPorStatus(status);
        return ResponseEntity.ok(treinos);
    }
}