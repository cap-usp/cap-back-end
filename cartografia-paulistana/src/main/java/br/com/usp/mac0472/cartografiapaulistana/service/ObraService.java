package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTipo;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTitulo;
import br.com.usp.mac0472.cartografiapaulistana.enums.ObraStatus;
import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.model.Endereco;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.model.Referencia;
import br.com.usp.mac0472.cartografiapaulistana.repository.ObraRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;

	@Autowired
	private ConstrutoraService construtoraService;

	@Autowired
	private ArquitetoService arquitetoService;

	public Page<Obra> readObras(Pageable pageable, Boolean validadasProfessora, Boolean validadasDph) {
		return repository.findObras(pageable, validadasProfessora, validadasDph);
	}

	public Optional<Obra> readObra(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Obra createObra(Obra obra, ObraCreateDto obraDto, Endereco endereco) {
		Construtora construtora = construtoraService.readConstrutora(obraDto.construtoraId())
				.orElseThrow(() -> new EntityNotFoundException("Construtora não encontrada."));
		
		Set<Arquiteto> arquitetos = Set.copyOf(obraDto.arquitetosId().stream().map(autoriaId -> {
			return arquitetoService.readArquiteto(autoriaId).orElseThrow(() -> new EntityNotFoundException("Arquiteto não encontrado."));
		}).toList());
		
		Set<Referencia> referencias = Set.copyOf(obraDto.referenciasObra().stream()
				.map(referenciaUrl -> new Referencia(referenciaUrl, obra)).toList());
		
		obra.setStatus(ObraStatus.getByNome(obraDto.statusObra()));
		
		endereco.setEnderecoTipo(EnderecoTipo.getByNome(obraDto.enderecoObra().enderecoTipo()));
		endereco.setEnderecoTitulo(EnderecoTitulo.getByNome(obraDto.enderecoObra().enderecoTitulo()));
		
		obra.setConstrutora(construtora);
		obra.setArquitetos(arquitetos);
		obra.setReferencias(referencias);
		obra.setEndereco(endereco);
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
