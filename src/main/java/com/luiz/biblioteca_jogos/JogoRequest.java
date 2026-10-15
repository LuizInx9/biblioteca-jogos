package com.luiz.biblioteca_jogos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record JogoRequest(
    @NotBlank String titulo,
    @NotBlank String plataforma,
    @Min(0) @Max(10) double nota){
}

