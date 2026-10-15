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

    public Jogo adicionar(JogoRequest novoJogo) {
        validarNota(novoJogo);
        Jogo jogo = new Jogo(null, novoJogo.titulo(), novoJogo.plataforma(), novoJogo.nota());
        return jogoRepository.save(jogo);
    }

    public Jogo atualizar(Long id, JogoRequest dadosNovos) {
        validarNota(dadosNovos);
        Jogo jogo = buscarPorId(id);
        jogo.setTitulo(dadosNovos.titulo());
        jogo.setPlataforma(dadosNovos.plataforma());
        jogo.setNota(dadosNovos.nota());
        return jogoRepository.save(jogo);
    }

    public void deletar(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new JogoNaoEncontradoException(id);
        }
        jogoRepository.deleteById(id);
    }

    //METODO INTERNO - VALIDA NOTA

    private static void validarNota(JogoRequest request) {
        if (request.nota() < 0 || request.nota() > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
    }


}
