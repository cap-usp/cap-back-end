package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import lombok.Data;

@Data
public class ObraResponseDto {

	private Integer id;
	private String latitude;
	private String longitude;
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
	private String status;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;
	
}
