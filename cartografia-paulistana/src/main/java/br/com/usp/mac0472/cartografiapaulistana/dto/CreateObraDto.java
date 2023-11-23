package br.com.usp.mac0472.cartografiapaulistana.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateObraDto(
		@NotNull Double latitude, 
		@NotNull Double longitude, 
		@NotBlank String nomeOficial, 
		Integer anoProjeto,
		Integer anoConstrucao, 
		Integer condephaat, 
		Integer conpresp,
		Integer iphan,
		@NotBlank String usoOriginal,
		@NotBlank String codigoOriginal,
		String usoAtual,
		String codigoAtual,
		String condicao,
		Integer anoDemolicao,
		Integer anoReforma,
		Boolean validadoProfessora,
		Boolean validadoDPH,
		@NotNull Integer construtora_id
		) {

}
