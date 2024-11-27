package com.example.prova.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "exercicios", joinColumns = @JoinColumn(name = "treino_id"))
    @Column(name = "exercicio")
    private List<String> exercicios;

    @Column(nullable = false)
    private int series;

    @Column(nullable = false)
    private int repeticoes;

    @Column(name = "descanso_entre_series")
    private int descansoEntreSeries;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTreino status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<String> exercicios) {
        this.exercicios = exercicios;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getDescansoEntreSeries() {
        return descansoEntreSeries;
    }

    public void setDescansoEntreSeries(int descansoEntreSeries) {
        this.descansoEntreSeries = descansoEntreSeries;
    }

    public StatusTreino getStatus() {
        return status;
    }

    public void setStatus(StatusTreino status) {
        this.status = status;
    }
}


