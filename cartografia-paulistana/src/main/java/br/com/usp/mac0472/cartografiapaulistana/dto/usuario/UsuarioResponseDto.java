package br.com.usp.mac0472.cartografiapaulistana.dto.usuario;

import lombok.Data;

@Data
public class UsuarioResponseDto {

	private Integer id;
	private String login;
	private String numeroUsp;
	private String email;
	
}
