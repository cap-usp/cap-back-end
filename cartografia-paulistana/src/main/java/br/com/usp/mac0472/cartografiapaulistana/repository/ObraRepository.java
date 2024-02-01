package br.com.usp.mac0472.cartografiapaulistana.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usp.mac0472.cartografiapaulistana.model.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {

	Page<Obra> findByValidadoProfessoraAndValidadoDPH(Boolean validadoProfessora, Boolean validadoDPH, Pageable pageable);

}
