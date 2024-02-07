package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTipo;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTitulo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoCreateDto(
			@NotNull EnderecoTipo enderecoTipo,
			EnderecoTitulo enderecoTitulo,
			@NotBlank String logradouro,
			@NotNull Integer numero,
			String complemento,
			@NotBlank String cep,
			@NotBlank String municipio
		) {
	
}
