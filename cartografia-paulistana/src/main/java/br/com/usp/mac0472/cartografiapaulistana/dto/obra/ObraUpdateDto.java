package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import java.util.List;

public record ObraUpdateDto(
		String latitude, 
		String longitude, 
		String nomeOficial,
		List<Integer> arquitetoId,
		Integer anoProjeto,
		Integer anoConstrucao, 
		Integer condephaat, 
		Integer conpresp,
		Integer iphan,
		String usoOriginal,
		String codigoOriginal,
		String usoAtual,
		String codigoAtual,
		String statusObra,
		String escritorio,
		String nomeAlternativo,
		Integer construtoraId,
		Integer dataUsoAtual,
		Integer anoDemolicao,
		Integer anoRestauro,
		List<Integer> arquitetoReforma,
		List<String> referencias,
		EnderecoCreateDto endereco
		) {

}
