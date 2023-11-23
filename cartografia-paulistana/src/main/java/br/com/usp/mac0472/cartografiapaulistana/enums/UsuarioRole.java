package br.com.usp.mac0472.cartografiapaulistana.enums;

public enum UsuarioRole {

	ADMIN("admin"), USER("user");

	private String role;

	UsuarioRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}
}
