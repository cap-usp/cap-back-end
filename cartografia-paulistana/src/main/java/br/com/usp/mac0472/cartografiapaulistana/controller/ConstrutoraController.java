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

import br.com.usp.mac0472.cartografiapaulistana.model.Construtora;
import br.com.usp.mac0472.cartografiapaulistana.service.ConstrutoraService;

@RestController
@RequestMapping("/api/construtora")
public class ConstrutoraController {

	@Autowired
	private ConstrutoraService service;

	@GetMapping
	public ResponseEntity<List<Construtora>> getConstrutoras() {
		List<Construtora> construtoras = service.readConstrutoras();
		return ResponseEntity.ok(construtoras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Construtora> getConstrutora(@PathVariable Integer id) {
		Construtora construtora = service.readConstrutora(id);
		if (construtora != null) {
			return ResponseEntity.ok(construtora);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Construtora> createConstrutora(@RequestBody Construtora construtora) {
		Construtora construtoraCreated = service.createConstrutora(construtora);
		return ResponseEntity.status(HttpStatus.CREATED).body(construtoraCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Construtora> updateConstrutora(@PathVariable Integer id,
			@RequestBody Construtora construtora) {
		Construtora updatedConstrutora = service.updateConstrutora(id, construtora);
		if (updatedConstrutora != null) {
			return ResponseEntity.ok(updatedConstrutora);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConstrutora(@PathVariable Integer id) {
		boolean deleted = service.deleteConstrutora(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
