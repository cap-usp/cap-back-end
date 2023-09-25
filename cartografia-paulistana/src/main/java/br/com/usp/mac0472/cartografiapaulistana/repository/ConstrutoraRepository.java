package br.com.usp.mac0472.cartografiapaulistana.repository;

import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstrutoraRepository extends JpaRepository<Construtora,Integer> {
}
