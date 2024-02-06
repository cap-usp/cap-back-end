package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ObraCreateDto(
		@NotNull String latitude, 
		@NotNull String longitude, 
		@NotBlank String nomeOficial,
		@NotNull Integer arquitetoId,
		Integer anoProjeto,
		Integer anoConstrucao, 
		Integer condephaat, 
		Integer conpresp,
		Integer iphan,
		@NotBlank String usoOriginal,
		@NotBlank String codigoOriginal,
		String usoAtual,
		String codigoAtual,
		String status,
		@NotNull Integer construtoraId
		) {

}
