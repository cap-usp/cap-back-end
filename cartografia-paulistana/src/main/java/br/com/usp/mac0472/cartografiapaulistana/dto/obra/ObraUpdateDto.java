package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

public record ObraUpdateDto(
		String latitude, 
		String longitude, 
		String nomeOficial,
		Integer arquitetoId,
		Integer anoProjeto,
		Integer anoConstrucao, 
		Integer condephaat, 
		Integer conpresp,
		Integer iphan,
		String usoOriginal,
		String codigoOriginal,
		String usoAtual,
		String codigoAtual,
		String status,
		Integer construtoraId
		) {

}
