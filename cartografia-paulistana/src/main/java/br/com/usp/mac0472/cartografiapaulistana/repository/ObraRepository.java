package br.com.usp.mac0472.cartografiapaulistana.repository;

import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Integer> {
}
