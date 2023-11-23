package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateConstrutoraDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.repository.ConstrutoraRepository;
import jakarta.transaction.Transactional;

@Service
public class ConstrutoraService {

	@Autowired
	private ConstrutoraRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Page<Construtora> readConstrutoras(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Construtora> readConstrutora(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Construtora createConstrutora(CreateConstrutoraDto construtoraDto) {
		Construtora construtora = mapper.map(construtoraDto, Construtora.class);
		return repository.save(construtora);
	}

	@Transactional
	public Construtora updateConstrutora(Integer id, Construtora updatedConstrutora) {
		Construtora existingConstrutora = repository.getReferenceById(id);

		if (existingConstrutora != null) {
			existingConstrutora.update(updatedConstrutora);
			return repository.save(existingConstrutora);
		}

		return null;
	}

	@Transactional
	public void deleteConstrutora(Integer id) {
		this.repository.deleteById(id);
	}
}
