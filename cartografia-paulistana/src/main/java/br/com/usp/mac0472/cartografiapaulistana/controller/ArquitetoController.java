package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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

import br.com.usp.mac0472.cartografiapaulistana.dto.arquiteto.ArquitetoCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.arquiteto.ArquitetoResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.arquiteto.ArquitetoUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.service.ArquitetoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/arquitetos")
public class ArquitetoController {

	@Autowired
	private ArquitetoService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<ArquitetoResponseDto>> getArquitetos(Pageable pageable) {
		Page<Arquiteto> arquitetos = service.readArquitetos(pageable);
		List<ArquitetoResponseDto> arquitetosDto = arquitetos.stream()
				.map(arquiteto -> mapper.map(arquiteto, ArquitetoResponseDto.class)).toList();
		Page<ArquitetoResponseDto> response = PageableExecutionUtils.getPage(arquitetosDto, pageable,
				() -> arquitetos.getTotalElements());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ArquitetoResponseDto> getArquiteto(@PathVariable Integer id) {
		Optional<Arquiteto> arquiteto = service.readArquiteto(id);
		if (arquiteto.isPresent()) {
			ArquitetoResponseDto response = mapper.map(arquiteto.get(), ArquitetoResponseDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ArquitetoResponseDto> createArquiteto(@RequestBody @Valid ArquitetoCreateDto arquitetoDto) {
		Arquiteto arquiteto = mapper.map(arquitetoDto, Arquiteto.class);
		service.createArquiteto(arquiteto);
		ArquitetoResponseDto response = mapper.map(arquiteto, ArquitetoResponseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ArquitetoResponseDto> updateArquiteto(@PathVariable Integer id,
			@RequestBody ArquitetoUpdateDto arquitetoDto) {
		Optional<Arquiteto> updatedArquiteto = service.updateArquiteto(id, arquitetoDto);
		if (updatedArquiteto.isPresent()) {
			ArquitetoResponseDto response = mapper.map(updatedArquiteto.get(), ArquitetoResponseDto.class);
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
