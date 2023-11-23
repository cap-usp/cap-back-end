package br.com.usp.mac0472.cartografiapaulistana.dto;

public record UpdateObraDto(
		Double latitude, 
		Double longitude, 
		String nomeOficial, 
		Integer anoProjeto,
		Integer anoConstrucao, 
		Integer condephaat, 
		Integer conpresp,
		Integer iphan,
		String usoOriginal,
		String codigoOriginal,
		String usoAtual,
		String codigoAtual,
		String condicao,
		Integer anoDemolicao,
		Integer anoReforma,
		Boolean validadoProfessora,
		Boolean validadoDPH
		) {

}
