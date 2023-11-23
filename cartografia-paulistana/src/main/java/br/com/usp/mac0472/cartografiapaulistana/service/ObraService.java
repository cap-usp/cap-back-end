package br.com.usp.mac0472.cartografiapaulistana.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateObraDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.repository.ObraRepository;
import jakarta.transaction.Transactional;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Page<Obra> readObras(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Obra> readObra(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public Obra createObra(CreateObraDto obraDto) {
		Obra obra = mapper.map(obraDto, Obra.class);
		return repository.save(obra);
	}

	@Transactional
	public Obra updateObra(Integer id, Obra updatedObra) {
		Obra existingObra = repository.getReferenceById(id);

		if (existingObra != null) {
			existingObra.update(updatedObra);
			return repository.save(existingObra);
		}

		return null;
	}

	@Transactional
	public void deleteObra(Integer id) {
		this.repository.deleteById(id);
	}
}
