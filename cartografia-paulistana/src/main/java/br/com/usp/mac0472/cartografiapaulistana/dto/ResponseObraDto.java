package br.com.usp.mac0472.cartografiapaulistana.dto;

public record ResponseObraDto(
		Double latitude, 
		Double longitude, 
		String nomeOficial, 
		Integer anoProjeto,
		Integer anoConstrucao, 
		String usoAtual,
		String condicao,
		Integer anoReforma) {

}
