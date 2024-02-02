package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import lombok.Data;

@Data
public class ObraPageResponseDto {

	private Integer id;
	private String nomeOficial;
	private Integer anoProjeto; 
	private Integer anoConstrucao;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;
	
}
