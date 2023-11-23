package br.com.usp.mac0472.cartografiapaulistana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.usp.mac0472.cartografiapaulistana.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

	UserDetails findByLogin(String login);

}
