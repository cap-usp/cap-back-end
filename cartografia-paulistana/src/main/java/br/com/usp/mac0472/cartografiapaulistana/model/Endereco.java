package br.com.usp.mac0472.cartografiapaulistana.model;

import static jakarta.persistence.EnumType.STRING;

import java.util.Set;

import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTipo;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTitulo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "cep")
	private String cep;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "endereco_tipo")
	@Enumerated(STRING)
	private EnderecoTipo enderecoTipo;
	
	@Column(name = "endereco_titulo")
	@Enumerated(STRING)
	private EnderecoTitulo enderecoTitulo;

	@OneToMany(mappedBy = "endereco", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Set<Obra> obras;

}
