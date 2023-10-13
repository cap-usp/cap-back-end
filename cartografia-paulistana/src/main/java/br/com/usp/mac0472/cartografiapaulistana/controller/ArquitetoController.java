package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Arquiteto>> getArquitetos() {
		List<Arquiteto> arquitetos = service.readArquitetos();
		return ResponseEntity.ok(arquitetos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Arquiteto> getArquiteto(@PathVariable Integer id) {
		Arquiteto arquiteto = service.readArquiteto(id);
		if (arquiteto != null) {
			return ResponseEntity.ok(arquiteto);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Arquiteto> createArquiteto(Arquiteto arquiteto) {
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
		boolean deleted = service.deleteArquiteto(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
