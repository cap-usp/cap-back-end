package br.com.usp.mac0472.cartografiapaulistana.model;

import java.util.Objects;

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
@Table(name = "construtora")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Construtora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	public void update(Construtora updatedConstrutora) {
		if (Objects.nonNull(updatedConstrutora.nome)) {
			this.nome = updatedConstrutora.nome;
		}
	}

}
