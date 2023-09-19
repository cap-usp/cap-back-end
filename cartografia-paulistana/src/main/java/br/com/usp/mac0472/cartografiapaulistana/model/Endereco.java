package br.com.usp.mac0472.cartografiapaulistana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENDERECO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "obra_id", nullable = false)
	private Obra obra;

	@Column(name = "cep", nullable = false, length = 8)
	private String cep;

	@Column(name = "logradouro", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@Column(name = "bairro", nullable = false, length = 50)
	private String bairro;

	@Column(name = "distrito", nullable = false, length = 50)
	private String distrito;

	@Column(name = "municipio", nullable = false, length = 50)
	private String municipio;

	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@Column(name = "pais", nullable = false, length = 50)
	private String pais;

}
