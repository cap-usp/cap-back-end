package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import lombok.Data;

@Data
public class EnderecoResponseDto {

	private String enderecoTipo;
	private String enderecoTitulo;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String municipio;
	
}
