package br.com.usp.mac0472.cartografiapaulistana.model;

import static jakarta.persistence.EnumType.STRING;
import static java.util.Objects.nonNull;

import java.util.HashSet;
import java.util.Set;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.enums.ObraStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "obra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "nome_oficial")
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

	@Column(name = "uso_original")
	private String usoOriginal;

	@Column(name = "codigo_original")
	private String codigoOriginal;

	@Column(name = "uso_atual")
	private String usoAtual;

	@Column(name = "codigo_atual")
	private String codigoAtual;

	@Column(name = "status")
	@Enumerated(STRING)
	private ObraStatus status;

	@Column(name = "escritorio")
	private String escritorio;
	
	@Column(name = "nome_alternativo")
	private String nomeAlternativo;
	
	@Column(name = "data_uso_atual")
	private Integer dataUsoAtual;
	
	@Column(name = "ano_demolicao")
	private Integer anoDemolicao;

	@Column(name = "ano_restauro")
	private Integer anoRestauro;
	
	@Column(name = "validado_professora")
	private Boolean validadoProfessora;

	@Column(name = "validado_dph")
	private Boolean validadoDPH;

	@OneToMany(mappedBy = "obra", cascade = CascadeType.ALL)
	private Set<Referencia> referencias;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "construtora_id")
	private Construtora construtora;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "arquiteto_obra", joinColumns = { @JoinColumn(name = "obra_id") }, inverseJoinColumns = {
			@JoinColumn(name = "arquiteto_id") })
	private Set<Arquiteto> arquitetos = new HashSet<>();

	public void update(ObraUpdateDto updatedObra) {
		if (nonNull(updatedObra.latitude())) {
			this.latitude = updatedObra.latitude();
		}
		if (nonNull(updatedObra.longitude())) {
			this.longitude = updatedObra.longitude();
		}
		if (nonNull(updatedObra.nomeOficial())) {
			this.nomeOficial = updatedObra.nomeOficial();
		}
		if (nonNull(updatedObra.anoProjeto())) {
			this.anoProjeto = updatedObra.anoProjeto();
		}
		if (nonNull(updatedObra.anoConstrucao())) {
			this.anoConstrucao = updatedObra.anoConstrucao();
		}
		if (nonNull(updatedObra.condephaat())) {
			this.condephaat = updatedObra.condephaat();
		}
		if (nonNull(updatedObra.conpresp())) {
			this.conpresp = updatedObra.conpresp();
		}
		if (nonNull(updatedObra.iphan())) {
			this.iphan = updatedObra.iphan();
		}
		if (nonNull(updatedObra.usoOriginal())) {
			this.usoOriginal = updatedObra.usoOriginal();
		}
		if (nonNull(updatedObra.codigoOriginal())) {
			this.codigoOriginal = updatedObra.codigoOriginal();
		}
		if (nonNull(updatedObra.usoAtual())) {
			this.usoAtual = updatedObra.usoAtual();
		}
		if (nonNull(updatedObra.codigoAtual())) {
			this.codigoAtual = updatedObra.codigoAtual();
		}
		if (nonNull(updatedObra.statusObra())) {
			this.status = ObraStatus.valueOf(updatedObra.statusObra());
		}
	}

}
