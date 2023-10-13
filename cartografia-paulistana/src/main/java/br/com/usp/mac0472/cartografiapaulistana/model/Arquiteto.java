package br.com.usp.mac0472.cartografiapaulistana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ARQUITETO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arquiteto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 25)
	private String nome;

	@Column(name = "nome_meio", length = 25)
	private String nomeMeio;

	@Column(name = "sobrenome", length = 30)
	private String sobrenome;

	public void update(Arquiteto updatedArquiteto) {
		if (updatedArquiteto.nome != null) {
			this.nome = updatedArquiteto.nome;
		}
		if (updatedArquiteto.nomeMeio != null) {
			this.nomeMeio = updatedArquiteto.nomeMeio;
		}
		if (updatedArquiteto.sobrenome != null) {
			this.sobrenome = updatedArquiteto.sobrenome;
		}
	}
}
