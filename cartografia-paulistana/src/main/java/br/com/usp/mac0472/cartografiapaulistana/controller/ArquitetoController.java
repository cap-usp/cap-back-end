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

import br.com.usp.mac0472.cartografiapaulistana.model.Arquiteto;
import br.com.usp.mac0472.cartografiapaulistana.service.ArquitetoService;

@RestController
@RequestMapping("/api/arquiteto")
public class ArquitetoController {

	@Autowired
	private ArquitetoService service;

	@GetMapping
	public ResponseEntity<Page<Arquiteto>> getArquitetos(Pageable pageable) {
		Page<Arquiteto> arquitetos = service.readArquitetos(pageable);
		return ResponseEntity.ok(arquitetos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Arquiteto> getArquiteto(@PathVariable Integer id) {
		Optional<Arquiteto> arquiteto = service.readArquiteto(id);
		if (arquiteto.isPresent()) {
			return ResponseEntity.ok(arquiteto.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Arquiteto> createArquiteto(@RequestBody Arquiteto arquiteto) {
		Arquiteto arquitetoCreated = service.createArquiteto(arquiteto);
		return ResponseEntity.status(HttpStatus.CREATED).body(arquitetoCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Arquiteto> updateArquiteto(@PathVariable Integer id, @RequestBody Arquiteto arquiteto) {
		Arquiteto updatedArquiteto = service.updateArquiteto(id, arquiteto);
		if (updatedArquiteto != null) {
			return ResponseEntity.ok(updatedArquiteto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArquiteto(@PathVariable Integer id) {
		service.deleteArquiteto(id);
		return ResponseEntity.noContent().build();
	}

}
