package br.com.usp.mac0472.cartografiapaulistana.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateConstrutoraDto(@NotBlank String nome) {

}
