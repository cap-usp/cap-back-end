package br.com.usp.mac0472.cartografiapaulistana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;

@Repository
public interface ArquitetoRepository extends JpaRepository<Arquiteto, Integer> {

}
