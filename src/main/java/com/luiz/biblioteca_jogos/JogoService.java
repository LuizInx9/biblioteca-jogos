package com.luiz.biblioteca_jogos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }


    //METODOS CRUD

    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    public Jogo buscarPorId(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new JogoNaoEncontradoException(id));
    }

    public Jogo adicionar(Jogo novoJogo) {
        validarNota(novoJogo);
        novoJogo.setId(null);
        return jogoRepository.save(novoJogo);
    }

    public Jogo atualizar(Long id, Jogo dadosNovos) {
        validarNota(dadosNovos);
        Jogo jogo = buscarPorId(id);
        jogo.setTitulo(dadosNovos.getTitulo());
        jogo.setPlataforma(dadosNovos.getPlataforma());
        jogo.setNota(dadosNovos.getNota());
        return jogoRepository.save(jogo);
    }

    public void deletar(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new JogoNaoEncontradoException(id);
        }
        jogoRepository.deleteById(id);
    }

    //METODO INTERNO - VALIDA NOTA

    private static void validarNota(Jogo jogo) {
        if (jogo.getNota() < 0 || jogo.getNota() > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
    }


}
