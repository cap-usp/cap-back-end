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

import br.com.usp.mac0472.cartografiapaulistana.dto.construtora.ConstrutoraCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.construtora.ConstrutoraResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.construtora.ConstrutoraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.service.ConstrutoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/construtoras")
public class ConstrutoraController {

	@Autowired
	private ConstrutoraService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<ConstrutoraResponseDto>> getConstrutoras(Pageable pageable) {
		Page<Construtora> construtoras = service.readConstrutoras(pageable);
		List<ConstrutoraResponseDto> construtorasDto = construtoras.stream()
				.map(construtora -> mapper.map(construtora, ConstrutoraResponseDto.class)).toList();
		Page<ConstrutoraResponseDto> response = PageableExecutionUtils.getPage(construtorasDto, pageable,
				() -> construtoras.getTotalElements());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConstrutoraResponseDto> getConstrutora(@PathVariable Integer id) {
		Optional<Construtora> construtora = service.readConstrutora(id);
		if (construtora.isPresent()) {
			ConstrutoraResponseDto response = mapper.map(construtora.get(), ConstrutoraResponseDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ConstrutoraResponseDto> createConstrutora(
			@RequestBody @Valid ConstrutoraCreateDto construtoraDto) {
		Construtora construtora = mapper.map(construtoraDto, Construtora.class);
		service.createConstrutora(construtora);
		ConstrutoraResponseDto response = mapper.map(construtora, ConstrutoraResponseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ConstrutoraResponseDto> updateConstrutora(@PathVariable Integer id,
			@RequestBody ConstrutoraUpdateDto construtoraDto) {
		Optional<Construtora> updatedConstrutora = service.updateConstrutora(id, construtoraDto);
		if (updatedConstrutora.isPresent()) {
			ConstrutoraResponseDto response = mapper.map(updatedConstrutora.get(), ConstrutoraResponseDto.class);
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
