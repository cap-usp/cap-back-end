package br.com.usp.mac0472.cartografiapaulistana.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.usp.mac0472.cartografiapaulistana.model.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {

	@Query("SELECT o FROM Obra o WHERE o.validadoProfessora = :validadasProfessora AND o.validadoDPH = :validadasDph")
	Page<Obra> findObras(Pageable pageable, Boolean validadasProfessora, Boolean validadasDph);

}
