package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.repository.ObraRepository;
import jakarta.transaction.Transactional;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;

	public Page<Obra> readObras(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Obra> readObra(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Obra createObra(Obra obra) {
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

	public Page<Obra> getValidadas(Boolean validadoProfessora, Boolean validadoDPH) {
		return repository.findByValidadoProfessoraAndValidadoDPH(validadoProfessora, validadoDPH);
	}
}
