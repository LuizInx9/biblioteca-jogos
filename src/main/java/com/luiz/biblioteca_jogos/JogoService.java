package com.luiz.biblioteca_jogos;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogoService {

    private List<Jogo> jogos = new ArrayList<>();

    public JogoService() {
        Jogo jogo1 = new Jogo(1L, "HK", "PS4", 10);
        Jogo jogo2 = new Jogo(2L, "HK: Silksong", "PC", 9);
        Jogo jogo3 = new Jogo(3L, "Coffee Talk", "PS4", 10);

        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);

    }

    public List<Jogo> listar() {
        return jogos;
    }

    public Jogo buscarPorId(Long id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId().equals(id)) {
                return jogo;
            }
        }
        return null;
    }

    public Jogo adicionar(Jogo novoJogo) {
        if (novoJogo.getNota() < 0 || novoJogo.getNota() > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
        jogos.add(novoJogo);
        return novoJogo;
    }

    public Jogo atualizar(Long id, Jogo dadosNovos) {
        for (Jogo jogo : jogos) {
            if (jogo.getNota() < 0 || jogo.getNota() > 10) {
                throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
            }

            if (jogo.getId().equals(id)) {
                jogo.setTitulo(dadosNovos.getTitulo());
                jogo.setPlataforma(dadosNovos.getPlataforma());
                jogo.setNota(dadosNovos.getNota());
                return jogo;

            }

        }
        return null;
    }

    public void deletar(Long id){
        jogos.removeIf(jogo -> jogo.getId().equals(id));
    }

}
