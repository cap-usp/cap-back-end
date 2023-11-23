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

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateArquitetoDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.ResponseArquitetoDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.service.ArquitetoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/arquiteto")
public class ArquitetoController {

	@Autowired
	private ArquitetoService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<Arquiteto>> getArquitetos(Pageable pageable) {
		Page<Arquiteto> arquitetos = service.readArquitetos(pageable);
		return ResponseEntity.ok(arquitetos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseArquitetoDto> getArquiteto(@PathVariable Integer id) {
		Optional<Arquiteto> arquiteto = service.readArquiteto(id);
		if (arquiteto.isPresent()) {
			ResponseArquitetoDto response = mapper.map(arquiteto.get(), ResponseArquitetoDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ResponseArquitetoDto> createArquiteto(@RequestBody @Valid CreateArquitetoDto arquitetoDto) {
		Arquiteto arquiteto = mapper.map(arquitetoDto, Arquiteto.class);
		service.createArquiteto(arquiteto);
		ResponseArquitetoDto response = mapper.map(arquiteto, ResponseArquitetoDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseArquitetoDto> updateArquiteto(@PathVariable Integer id,
			@RequestBody Arquiteto arquiteto) {
		Optional<Arquiteto> updatedArquiteto = service.updateArquiteto(id, arquiteto);
		if (updatedArquiteto.isPresent()) {
			ResponseArquitetoDto response = mapper.map(updatedArquiteto.get(), ResponseArquitetoDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArquiteto(@PathVariable Integer id) {
		service.deleteArquiteto(id);
		return ResponseEntity.noContent().build();
	}

}
