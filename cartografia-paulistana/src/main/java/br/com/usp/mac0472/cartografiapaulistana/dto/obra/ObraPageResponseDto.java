package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import java.util.List;

import lombok.Data;

@Data
public class ObraPageResponseDto {

	private Integer id;
	private String nomeOficial;
	private List<String> autorias;
	private String usoOriginal;
	private String municipio;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;
	
}
