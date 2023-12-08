package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UserCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UserLoginDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Usuario;
import br.com.usp.mac0472.cartografiapaulistana.repository.UserRepository;
import br.com.usp.mac0472.cartografiapaulistana.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AutenticacaoController {

	@Autowired
	private UserRepository repository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody UserLoginDto data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((Usuario) auth.getPrincipal());

		return ResponseEntity.ok(token);
	}

	@PostMapping("cadastro")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UserCreateDto data) {
		if (Objects.nonNull(this.repository.findByLogin(data.login()))) {
			return ResponseEntity.badRequest().build();
		}
		String senhaEncriptada = new BCryptPasswordEncoder().encode(data.senha());
		Usuario novoUsuario = new Usuario(data.login(), senhaEncriptada);
		this.repository.save(novoUsuario);
		return ResponseEntity.ok().build();
	}
}
