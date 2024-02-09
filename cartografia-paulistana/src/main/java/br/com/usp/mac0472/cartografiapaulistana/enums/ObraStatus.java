package br.com.usp.mac0472.cartografiapaulistana.enums;

import java.util.Arrays;

public enum ObraStatus {

	RESTAURADO("Restaurado"), REFORMADO("Reformado"), DEMOLIDO("Demolido"), CONSTRUIDO("Construído");
	
	private String nome;
	
	ObraStatus(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
    public static ObraStatus getByNome(String nome) {
        return Arrays.stream(ObraStatus.values())
                .filter(status -> status.nome.equals(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Obra status não existente"));
    }

}
