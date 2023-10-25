package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.repository.ConstrutoraRepository;
import jakarta.transaction.Transactional;

@Service
public class ConstrutoraService {

	@Autowired
	private ConstrutoraRepository repository;

	public List<Construtora> readConstrutoras() {
		return repository.findAll();
	}

	public Construtora readConstrutora(Integer id) {
		return repository.findById(id).get();
	}

	@Transactional
	public Construtora createConstrutora(Construtora construtora) {
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
	public boolean deleteConstrutora(Integer id) {
		Construtora construtora = repository.getReferenceById(id);

		if (construtora != null) {
			repository.deleteById(id);
			return true;
		}

		return false;
	}
}
