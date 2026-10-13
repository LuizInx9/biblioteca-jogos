package com.luiz.biblioteca_jogos;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    //MOSTRA A LISTA DE JOGOS

    @GetMapping("/jogos")
    public List<Jogo> listarJogos() {
        return jogoService.listar();
    }

    //BUSCA UMA ID ESPECIFICA

    @GetMapping("/jogos/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        return jogoService.buscarPorId(id);
    }

    //INSERE NOVO JOGO NA LISTA

    @PostMapping("/jogos")
    public Jogo adicionar(@RequestBody Jogo novoJogo) {
        return jogoService.adicionar(novoJogo);
    }

    //ATUALIZA INFORMAÇÔES DE JOGO EXISTENTE

    @PutMapping("/jogos/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo novasInfos) {
        return jogoService.atualizar(id, novasInfos);
    }

    //DELETA JOGO

    @DeleteMapping("/jogos/{id}")
    public void deletar(@PathVariable Long id) {
        jogoService.deletar(id);
    }

}
