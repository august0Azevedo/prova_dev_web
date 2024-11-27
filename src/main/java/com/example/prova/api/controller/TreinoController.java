package com.example.prova.api.controller;


import com.example.prova.api.entity.Treino;
import com.example.prova.api.entity.StatusTreino;
import com.example.prova.api.service.TreinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public ResponseEntity<Treino> criarTreino(@RequestBody Treino treino) {
        Treino novoTreino = treinoService.criarTreino(treino);
        return ResponseEntity.ok(novoTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizarTreino(@PathVariable Long id, @RequestBody Treino treinoAtualizado) {
        Treino treino = treinoService.atualizarTreino(id, treinoAtualizado);
        return treino != null ? ResponseEntity.ok(treino) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTreino(@PathVariable Long id) {
        treinoService.deletarTreino(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping
    public ResponseEntity<List<Treino>> listarTreinos(@RequestParam(required = false) StatusTreino status) {
        if (status != null) {
            List<Treino> treinos = treinoService.buscarTreinosPorStatus(status);
            return ResponseEntity.ok(treinos);
        } else {
            List<Treino> treinos = treinoService.listarTodosTreinos().getBody();
            return ResponseEntity.ok(treinos);
        }
    }
}