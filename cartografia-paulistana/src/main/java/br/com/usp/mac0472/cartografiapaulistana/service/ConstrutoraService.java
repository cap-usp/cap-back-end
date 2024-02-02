package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.construtora.ConstrutoraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.repository.ConstrutoraRepository;
import jakarta.transaction.Transactional;

@Service
public class ConstrutoraService {

	@Autowired
	private ConstrutoraRepository repository;

	public Page<Construtora> readConstrutoras(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Construtora> readConstrutora(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Construtora createConstrutora(Construtora construtora) {
		return repository.save(construtora);
	}

	@Transactional
	public Optional<Construtora> updateConstrutora(Integer id, ConstrutoraUpdateDto updatedConstrutora) {
		Construtora existingConstrutora = repository.getReferenceById(id);
		existingConstrutora.update(updatedConstrutora);
		repository.save(existingConstrutora);
		return Optional.ofNullable(existingConstrutora);
	}

	@Transactional
	public void deleteConstrutora(Integer id) {
		this.repository.deleteById(id);
	}
}
