package com.luiz.biblioteca_jogos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class JogoController {


    private List<Jogo> jogos = new ArrayList<>();


    public JogoController() {
        Jogo jogo1 = new Jogo(1L, "HK", "PS4", 10);
        Jogo jogo2 = new Jogo(2L, "HK: Silksong", "PC", 10);
        Jogo jogo3 = new Jogo(3L, "Coffee Talk", "PS4", 9);

        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);

    }

    @GetMapping("/jogos/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId().equals(id)) {
                return jogo;
            }
        }
        return null;
    }


    @GetMapping("/jogos")
    public List<Jogo> listarJogos() {
        return jogos;
    }

    @PostMapping("/jogos")
    public Jogo adicionarJogo(@RequestBody Jogo novoJogo){
        jogos.add(novoJogo);
        return novoJogo;
    }

    @PutMapping("/jogos/{id}")
    public Jogo atualizarJogo(@PathVariable Long id, @RequestBody Jogo dadosNovos){
        for (Jogo jogo : jogos) {
            if(jogo.getId().equals(id)){
                jogo.setTitulo(dadosNovos.getTitulo());
                jogo.setPlataforma(dadosNovos.getPlataforma());
                jogo.setNota(dadosNovos.getNota());
                return jogo;

            }

        }
        return null;
    }


}
