package br.com.usp.mac0472.cartografiapaulistana.model;

import static java.util.Objects.nonNull;

import java.util.Set;

import br.com.usp.mac0472.cartografiapaulistana.dto.construtora.ConstrutoraUpdateDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "construtora", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Set<Obra> obras;

	public void update(ConstrutoraUpdateDto updatedConstrutora) {
		if (nonNull(updatedConstrutora.nome())) {
			this.nome = updatedConstrutora.nome();
		}
	}

}
