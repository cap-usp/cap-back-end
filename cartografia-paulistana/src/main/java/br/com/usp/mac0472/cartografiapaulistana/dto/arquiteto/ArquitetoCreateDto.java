package br.com.usp.mac0472.cartografiapaulistana.dto.arquiteto;

import jakarta.validation.constraints.NotBlank;

public record ArquitetoCreateDto(@NotBlank String nome, String nomeMeio, @NotBlank String sobrenome) {

}
