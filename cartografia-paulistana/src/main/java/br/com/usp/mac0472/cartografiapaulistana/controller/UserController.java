package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UsuarioResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UsuarioUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Usuario;
import br.com.usp.mac0472.cartografiapaulistana.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioResponseDto>> getUsuarios(Pageable pageable) {
		Page<Usuario> usuarios = service.readUsuarios(pageable);
		List<UsuarioResponseDto> usuariosDto = usuarios.stream()
				.map(usuario -> mapper.map(usuario, UsuarioResponseDto.class)).toList();
		Page<UsuarioResponseDto> response = PageableExecutionUtils.getPage(usuariosDto, pageable, () -> usuarios.getTotalElements());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> getUsuario(@PathVariable Integer id){
		Usuario usuario = service.readUsuario(id);
		UsuarioResponseDto response = mapper.map(usuario, UsuarioResponseDto.class);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioUpdateDto usuarioDto){
		Usuario usuario = service.updateUsuario(id, usuarioDto);
		UsuarioResponseDto response = mapper.map(usuario, UsuarioResponseDto.class);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
		service.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
}
