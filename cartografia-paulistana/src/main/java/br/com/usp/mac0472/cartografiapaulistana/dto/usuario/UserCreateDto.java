package br.com.usp.mac0472.cartografiapaulistana.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDto(@NotBlank String login, @NotBlank String senha, @NotBlank String numeroUsp, @NotBlank String email, @NotBlank String autorizacao) {

}
