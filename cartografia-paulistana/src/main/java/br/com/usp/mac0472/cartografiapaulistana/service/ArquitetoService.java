package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.UpdateArquitetoDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.repository.ArquitetoRepository;
import jakarta.transaction.Transactional;

@Service
public class ArquitetoService {

	@Autowired
	private ArquitetoRepository repository;

	public Page<Arquiteto> readArquitetos(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Arquiteto> readArquiteto(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Arquiteto createArquiteto(Arquiteto arquiteto) {
		return repository.save(arquiteto);
	}

	@Transactional
	public Optional<Arquiteto> updateArquiteto(Integer id, UpdateArquitetoDto updatedArquiteto) {
		Arquiteto existingArquiteto = repository.getReferenceById(id);
		existingArquiteto.update(updatedArquiteto);
		repository.save(existingArquiteto);
		return Optional.ofNullable(existingArquiteto);
	}

	@Transactional
	public void deleteArquiteto(Integer id) {
		this.repository.deleteById(id);
	}
}
