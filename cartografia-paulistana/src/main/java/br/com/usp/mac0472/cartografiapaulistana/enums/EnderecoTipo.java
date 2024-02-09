package br.com.usp.mac0472.cartografiapaulistana.enums;

import java.util.Arrays;

public enum EnderecoTipo {

	TRAVESSA("Travessa"), ACESSO("Acesso"), ALAMEDA("Alameda"), AVENIDA("Avenida"), BECO("Beco"), CAMINHO("Caminho"),
	COMPLEXO_VIARIO("Complexo Viário"), ESPLANADA("Esplanada"), ESTRADA("Estrada"), GALERIA("Galeria"),
	JARDIM("Jardim"), LADEIRA("Ladeira"), LARGO("Largo"), PARQUE("Parque"), PASSAGEM("Passagem"),
	PASSARELA("Passarela"), PATIO("Pátio"), PONTE("Ponte"), PRAÇA("Praça"), RODOVIA("Rodovia"), RUA("Rua"),
	SERVIDAO("Servidão"), TUNEL("Túnel"), VEREDA("Vereda"), VIA("Via"), VIELA("Viela"), VILA("Vila");

	private String nome;
	
	EnderecoTipo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
    public static EnderecoTipo getByNome(String nome) {
        return Arrays.stream(EnderecoTipo.values())
                .filter(status -> status.nome.equals(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Endereço tipo não existente"));
    }
}
