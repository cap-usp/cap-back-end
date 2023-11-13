package br.com.usp.mac0472.cartografiapaulistana.service;


import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.repository.ObraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    @Autowired
    private ObraRepository repository;

    public List<Obra> readObras() {
        return repository.findAll();
    }

    public Obra readObra(Integer id) {
        return repository.getReferenceById(id);
    }

    @Transactional
    public Obra createObra(Obra obra) {
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
    public boolean deleteObra(Integer id) {
        Obra obra = repository.getReferenceById(id);

        if (obra != null) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
