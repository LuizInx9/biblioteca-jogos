package com.luiz.biblioteca_jogos;

import jakarta.persistence.*;

@Entity
@Table(name = "jogos")

public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String plataforma;
    private double nota;

    public Jogo() {

    }

    public Jogo(Long id, String titulo, String plataforma, double nota) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.nota = nota;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getNota() {
        return nota;
    }
}
