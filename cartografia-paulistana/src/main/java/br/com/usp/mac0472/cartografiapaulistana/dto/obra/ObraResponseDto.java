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
	private String usoAtual;
	private String condicao;
	private Integer anoReforma;
	
}
