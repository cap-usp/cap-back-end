package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoCreateDto(
			@NotNull String enderecoTipo,
			String enderecoTitulo,
			@NotBlank String logradouro,
			@NotNull Integer numero,
			String complemento,
			@NotBlank String cep,
			@NotBlank String municipio
		) {
	
}
