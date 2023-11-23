package br.com.usp.mac0472.cartografiapaulistana.model;

import static java.util.Objects.nonNull;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "arquiteto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arquiteto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nome_meio")
	private String nomeMeio;

	@Column(name = "sobrenome")
	private String sobrenome;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "arquiteto_obra", joinColumns = { @JoinColumn(name = "arquiteto_id") }, inverseJoinColumns = {
			@JoinColumn(name = "obra_id") })
	private Set<Obra> obras = new HashSet<>();

	public void update(Arquiteto updatedArquiteto) {
		if (nonNull(updatedArquiteto.nome)) {
			this.nome = updatedArquiteto.nome;
		}
		if (nonNull(updatedArquiteto.nomeMeio)) {
			this.nomeMeio = updatedArquiteto.nomeMeio;
		}
		if (nonNull(updatedArquiteto.sobrenome)) {
			this.sobrenome = updatedArquiteto.sobrenome;
		}
	}
}
