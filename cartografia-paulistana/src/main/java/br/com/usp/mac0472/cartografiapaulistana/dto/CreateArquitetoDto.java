package br.com.usp.mac0472.cartografiapaulistana.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateArquitetoDto(@NotBlank String nome, @NotBlank String nomeMeio, @NotBlank String sobrenom) {

}
