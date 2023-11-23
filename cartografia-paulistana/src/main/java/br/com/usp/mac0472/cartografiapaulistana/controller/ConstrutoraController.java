package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateConstrutoraDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.ResponseConstrutoraDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.service.ConstrutoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/construtora")
public class ConstrutoraController {

	@Autowired
	private ConstrutoraService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<Construtora>> getConstrutoras(Pageable pageable) {
		Page<Construtora> construtoras = service.readConstrutoras(pageable);
		return ResponseEntity.ok(construtoras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseConstrutoraDto> getConstrutora(@PathVariable Integer id) {
		Optional<Construtora> construtora = service.readConstrutora(id);
		if (construtora.isPresent()) {
			ResponseConstrutoraDto response = mapper.map(construtora.get(), ResponseConstrutoraDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ResponseConstrutoraDto> createConstrutora(
			@RequestBody @Valid CreateConstrutoraDto construtoraDto) {
		Construtora construtora = mapper.map(construtoraDto, Construtora.class);
		service.createConstrutora(construtora);
		ResponseConstrutoraDto response = mapper.map(construtora, ResponseConstrutoraDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseConstrutoraDto> updateConstrutora(@PathVariable Integer id,
			@RequestBody Construtora construtora) {
		Optional<Construtora> updatedConstrutora = service.updateConstrutora(id, construtora);
		if (updatedConstrutora.isPresent()) {
			ResponseConstrutoraDto response = mapper.map(updatedConstrutora.get(), ResponseConstrutoraDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConstrutora(@PathVariable Integer id) {
		service.deleteConstrutora(id);
		return ResponseEntity.noContent().build();
	}

}
