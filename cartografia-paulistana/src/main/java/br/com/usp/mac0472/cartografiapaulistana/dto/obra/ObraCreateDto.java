package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ObraCreateDto(
		@NotNull String latitude, 
		@NotNull String longitude, 
		@NotBlank String nomeOficial,
		@NotEmpty List<Integer> arquitetosId,
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
		String escritorio,
		String nomeAlternativo,
		Integer construtoraId,
		Integer dataUsoAtual,
		Integer anoDemolicao,
		Integer anoRestauro,
		List<Integer> arquitetoReforma,
		@NotEmpty List<String> referencias,
		@NotNull EnderecoCreateDto enderecoObra
		) {

}
