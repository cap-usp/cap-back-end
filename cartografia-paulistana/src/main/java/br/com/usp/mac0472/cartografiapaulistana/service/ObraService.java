package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.model.Endereco;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.repository.EnderecoRepository;
import br.com.usp.mac0472.cartografiapaulistana.repository.ObraRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ConstrutoraService construtoraService;
	
	@Autowired
	private ArquitetoService arquitetoService;

	public Page<Obra> readObras(Pageable pageable, Boolean validadasProfessora, Boolean validadasDph) {
		validadasProfessora = validadasProfessora ? validadasProfessora : false;
		validadasDph = validadasDph ? validadasDph : false;
		return repository.findObras(pageable, validadasProfessora, validadasDph);
	}

	public Optional<Obra> readObra(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Obra createObra(Obra obra, List<Integer> arquitetosId, Integer construtoraId, Endereco endereco) {
		Construtora construtora = construtoraService.readConstrutora(construtoraId)
				.orElseThrow(() -> new EntityNotFoundException());
		Set<Arquiteto> arquitetos = Set.copyOf(arquitetosId.stream().map(autoriaId -> {
			return arquitetoService.readArquiteto(autoriaId).orElseThrow(() -> new EntityNotFoundException("Arquiteto não encontrado."));
		}).toList());
		obra.setConstrutora(construtora);
		obra.setArquitetos(arquitetos);
		obra.setValidadoDPH(false);
		obra.setValidadoProfessora(false);
		return repository.save(obra);
	}

	@Transactional
	public Optional<Obra> updateObra(Integer id, ObraUpdateDto updatedObra) {
		Obra existingObra = repository.getReferenceById(id);
		existingObra.update(updatedObra);
		repository.save(existingObra);
		return Optional.ofNullable(existingObra);
	}

	@Transactional
	public void deleteObra(Integer id) {
		repository.deleteById(id);
	}

	@Transactional
	public Obra validacaoProfessora(Integer id) {
		Obra existingObra = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		existingObra.setValidadoProfessora(!existingObra.getValidadoProfessora());
		repository.save(existingObra);
		return existingObra;
	}

	@Transactional
	public Obra validacaoDPH(Integer id) {
		Obra existingObra = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		existingObra.setValidadoDPH(!existingObra.getValidadoDPH());
		repository.save(existingObra);
		return existingObra;
	}
}
