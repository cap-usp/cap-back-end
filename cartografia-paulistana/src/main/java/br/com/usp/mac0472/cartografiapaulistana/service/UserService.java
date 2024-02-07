package br.com.usp.mac0472.cartografiapaulistana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UsuarioUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Usuario;
import br.com.usp.mac0472.cartografiapaulistana.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Page<Usuario> readUsuarios(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Usuario updateUsuario(Integer id, UsuarioUpdateDto updatedUsuario) {
		Usuario existingUsuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
		String senhaEncriptada = new BCryptPasswordEncoder().encode(updatedUsuario.senha());
		existingUsuario.update(updatedUsuario, senhaEncriptada);
		repository.save(existingUsuario);
		return existingUsuario;
	}
	
	public Usuario readUsuario(Integer id){
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
	}
	
	public void deleteUsuario(Integer id) {
		this.repository.deleteById(id);
	}
}
