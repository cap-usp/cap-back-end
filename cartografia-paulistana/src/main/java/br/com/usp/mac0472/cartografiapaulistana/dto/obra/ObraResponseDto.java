package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import java.util.Set;

import lombok.Data;

@Data
public class ObraResponseDto {

	private Integer id;
	private String latitude;
	private String longitude;
	private String nomeOficial;
	private Set<String> arquitetosNome;
	private Integer anoProjeto;
	private Integer anoConstrucao;
	private Integer condephaat;
	private Integer conpresp;
	private Integer iphan;
	private String usoOriginal;
	private String codigoOriginal;
	private String usoAtual;
	private String codigoAtual;
	private String status;
	private String escritorio;
	private String nomeAlternativo;
	private String construtoraObra;
	private Integer dataUsoAtual;
	private Integer anoDemolicao;
	private Integer anoRestauro;
	private Set<String> arquitetoReformaNome;
	private Set<String> referenciasObra;
	private EnderecoCreateDto enderecoObra;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;

}
