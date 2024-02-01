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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraPageResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraValidadaPageResponseDto;
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
	public ResponseEntity<Page<ObraPageResponseDto>> getObras(Pageable pageable) {
		Page<Obra> obras = service.readObras(pageable);
		List<ObraPageResponseDto> obrasDto = obras.stream().map(obra -> mapper.map(obra, ObraPageResponseDto.class))
				.toList();
		Page<ObraPageResponseDto> response = PageableExecutionUtils.getPage(obrasDto, pageable,
				() -> obras.getTotalElements());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ObraResponseDto> getObra(@PathVariable Integer id) {
		Optional<Obra> obra = service.readObra(id);
		if (obra.isPresent()) {
			ObraResponseDto response = mapper.map(obra.get(), ObraResponseDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ObraResponseDto> createObra(@RequestBody @Valid ObraCreateDto obraDto) {
		Obra obra = mapper.map(obraDto, Obra.class);
		service.createObra(obra, obraDto.construtoraId());
		ObraResponseDto response = mapper.map(obra, ObraResponseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ObraResponseDto> updateObra(@PathVariable Integer id, @RequestBody ObraUpdateDto obraDto) {
		Optional<Obra> updatedObra = service.updateObra(id, obraDto);
		if (updatedObra.isPresent()) {
			ObraResponseDto response = mapper.map(updatedObra.get(), ObraResponseDto.class);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteObra(@PathVariable Integer id) {
		service.deleteObra(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscarValidadasProfessora")
	public ResponseEntity<Page<ObraValidadaPageResponseDto>> getValidadas(Pageable pageable,
			@RequestParam Boolean validadoProfessora, @RequestParam Boolean validadoDPH) {
		Page<Obra> obras = service.getValidadas(validadoProfessora, validadoDPH, pageable);
		List<ObraValidadaPageResponseDto> obrasDto = obras.stream()
				.map(obra -> mapper.map(obra, ObraValidadaPageResponseDto.class)).toList();
		Page<ObraValidadaPageResponseDto> response = PageableExecutionUtils.getPage(obrasDto, pageable,
				() -> obras.getTotalElements());
		return ResponseEntity.ok(response);
	}

}
