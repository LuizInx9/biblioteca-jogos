package com.luiz.biblioteca_jogos;

public class JogoNaoEncontradoException extends RuntimeException {

    public JogoNaoEncontradoException(Long id) {
        super("Jogo não encontrado: " + id);
    }
}
