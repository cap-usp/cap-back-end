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

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateObraDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.ResponseObraDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.ResponsePageObraDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.UpdateObraDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.service.ObraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

	@Autowired
	private ObraService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<ResponsePageObraDto>> getObras(Pageable pageable) {
		Page<Obra> obras = service.readObras(pageable);
		List<ResponsePageObraDto> obrasDto = obras.stream().map(obra -> mapper.map(obra, ResponsePageObraDto.class))
				.toList();
		Page<ResponsePageObraDto> response = PageableExecutionUtils.getPage(obrasDto, pageable,
				() -> obras.getTotalElements());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseObraDto> getObra(@PathVariable Integer id) {
		Optional<Obra> obra = service.readObra(id);
		if (obra.isPresent()) {
			ResponseObraDto response = mapper.map(obra.get(), ResponseObraDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ResponseObraDto> createObra(@RequestBody @Valid CreateObraDto obraDto) {
		Obra obra = mapper.map(obraDto, Obra.class);
		service.createObra(obra);
		ResponseObraDto response = mapper.map(obra, ResponseObraDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObraDto> updateObra(@PathVariable Integer id, @RequestBody UpdateObraDto obraDto) {
		Optional<Obra> updatedObra = service.updateObra(id, obraDto);
		if (updatedObra.isPresent()) {
			ResponseObraDto response = mapper.map(updatedObra.get(), ResponseObraDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteObra(@PathVariable Integer id) {
		service.deleteObra(id);
		return ResponseEntity.noContent().build();
	}
}
