package br.com.usp.mac0472.cartografiapaulistana.dto.obra;

import java.util.Set;

import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.model.Referencia;
import lombok.Data;

@Data
public class ObraResponseDto {

	private String latitude;
	private String longitude;
	private String nomeOficial;
	private Set<Arquiteto> arquitetos;
	private Integer anoProjeto;
	private Integer anoConstrucao;
	private Integer condephaat;
	private Integer conpresp;
	private Integer iphan;
	private String usoOriginal;
	private String codigoOriginal;
	private String usoAtual;
	private String codigoAtual;
	private String status;
	private String escritorio;
	private String nomeAlternativo;
	private Construtora construtora;
	private Integer dataUsoAtual;
	private Integer anoDemolicao;
	private Integer anoRestauro;
	private Set<Integer> arquitetoReforma;
	private Set<Referencia> referencias;
	private EnderecoCreateDto endereco;
	private Boolean validadoProfessora;
	private Boolean validadoDPH;

}
