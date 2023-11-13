package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.repository.ArquitetoRepository;
import jakarta.transaction.Transactional;

@Service
public class ArquitetoService {

	@Autowired
	private ArquitetoRepository repository;

	public List<Arquiteto> readArquitetos() {
		return repository.findAll();
	}

	public Arquiteto readArquiteto(Integer id) {
		return repository.findById(id).get();
	}

	@Transactional
	public Arquiteto createArquiteto(Arquiteto arquiteto) {
		return repository.save(arquiteto);
	}

	@Transactional
	public Arquiteto updateArquiteto(Integer id, Arquiteto updatedArquiteto) {
		Arquiteto existingArquiteto = repository.getReferenceById(id);

		if (existingArquiteto != null) {
			existingArquiteto.update(updatedArquiteto);
			return repository.save(existingArquiteto);
		}

		return null;
	}

	@Transactional
	public boolean deleteArquiteto(Integer id) {
		Arquiteto arquiteto = repository.getReferenceById(id);

		if (arquiteto != null) {
			repository.deleteById(id);
			return true;
		}

		return false;
	}

}
