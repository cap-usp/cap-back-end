package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.Optional;

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

import br.com.usp.mac0472.cartografiapaulistana.dto.CreateObraDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.service.ObraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

	@Autowired
	private ObraService service;

	@GetMapping
	public ResponseEntity<Page<Obra>> getObras(Pageable pageable) {
		Page<Obra> obras = service.readObras(pageable);
		return ResponseEntity.ok(obras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Obra> getObra(@PathVariable Integer id) {
		Optional<Obra> obra = service.readObra(id);
		if (obra.isPresent()) {
			return ResponseEntity.ok(obra.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Obra> createObra(@RequestBody @Valid CreateObraDto obraDto) {
		Obra obraCreated = service.createObra(obraDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(obraCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Obra> updateObra(@PathVariable Integer id, @RequestBody Obra obra) {
		Obra updatedObra = service.updateObra(id, obra);
		if (updatedObra != null) {
			return ResponseEntity.ok(updatedObra);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteObra(@PathVariable Integer id) {
		service.deleteObra(id);
		return ResponseEntity.noContent().build();
	}
}
