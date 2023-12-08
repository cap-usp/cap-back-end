package br.com.usp.mac0472.cartografiapaulistana.dto.construtora;

import jakarta.validation.constraints.NotBlank;

public record ConstrutoraCreateDto(@NotBlank String nome) {

}
