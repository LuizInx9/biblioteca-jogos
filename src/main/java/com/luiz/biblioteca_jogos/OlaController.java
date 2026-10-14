package com.luiz.biblioteca_jogos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OlaController {
    @GetMapping("/ola")
    public String dizerOla() {
        return "Bem vindo à biblioteca de jogos";
    }

}
