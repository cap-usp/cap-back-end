package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import lombok.Data;

@Data
public class ObraResponseDto {

	private Integer id;
	private Double latitude;
	private Double longitude;
	private String nomeOficial; 
	private Integer anoProjeto;
	private Integer anoConstrucao; 
	private Integer condephaat;
	private Integer conpresp;
	private Integer iphan;
	private String usoOriginal;
	private String codigoOriginal;
	private String usoAtual;
	private String codigoAtual;
	private String condicao;
	private Integer anoDemolicao;
	private Integer anoReforma;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;
	
}
