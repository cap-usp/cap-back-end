package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTipo;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTitulo;
import lombok.Data;

@Data
public class EnderecoResponseDto {

	private EnderecoTipo enderecoTipo;
	private EnderecoTitulo enderecoTitulo;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String municipio;
	
}
