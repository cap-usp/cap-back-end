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
@Table(name = "OBRA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "latitude", nullable = false)
	private Double latitude;

	@Column(name = "longitude", nullable = false)
	private Double longitude;

	@ManyToOne
	@JoinColumn(name = "construtora_id", nullable = false)
	private Construtora construtora;

	@Column(name = "nome_oficial", nullable = false, length = 80)
	private String nomeOficial;

	@Column(name = "ano_projeto")
	private Integer anoProjeto;

	@Column(name = "ano_construcao")
	private Integer anoConstrucao;

	@Column(name = "condephaat")
	private Integer condephaat;

	@Column(name = "conpresp")
	private Integer conpresp;

	@Column(name = "iphan")
	private Integer iphan;

	@Column(name = "uso_original", nullable = false, length = 30)
	private String usoOriginal;

	@Column(name = "codigo_original", nullable = false, length = 30)
	private String codigoOriginal;

	@Column(name = "uso_atual", length = 30)
	private String usoAtual;

	@Column(name = "codigo_atual", length = 30)
	private String codigoAtual;

	@Column(name = "condicao", length = 30)
	private String condicao;

	@Column(name = "ano_demolicao")
	private Integer anoDemolicao;

	@Column(name = "ano_reforma")
	private Integer anoReforma;

	@Column(name = "referencias", nullable = false, length = 1024)
	private String referencias;

}
