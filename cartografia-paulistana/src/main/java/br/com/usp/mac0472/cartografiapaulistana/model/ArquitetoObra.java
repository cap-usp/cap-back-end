package br.com.usp.mac0472.cartografiapaulistana.model;

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
@Table(name = "ARQUITETO_OBRA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArquitetoObra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "arquiteto_id", nullable = false)
	private Arquiteto arquiteto;

	@ManyToOne
	@JoinColumn(name = "obra_id", nullable = false)
	private Obra obra;

}
