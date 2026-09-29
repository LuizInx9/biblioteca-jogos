package com.luiz.biblioteca_jogos;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JogoController {

    @GetMapping("/jogos")

    public List<Jogo> listarJogos(){
       Jogo jogo1 = new Jogo(1L, "Hollow Knight", "PS4", 10);
       Jogo jogo2 = new Jogo(2L, "Hollow Knight: Silksong", "PC" , 10);
       Jogo jogo3 = new Jogo(3L, "Coffee Talk", "PS4", 10);

       List<Jogo> jogos = new ArrayList<>();
       jogos.add(jogo1);
       jogos.add(jogo2);
       jogos.add(jogo3);

       return jogos;
    }


}
