package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraPageResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTipo;
import br.com.usp.mac0472.cartografiapaulistana.enums.EnderecoTitulo;
import br.com.usp.mac0472.cartografiapaulistana.enums.ObraStatus;
import br.com.usp.mac0472.cartografiapaulistana.model.Endereco;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.service.ObraService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/obras")
@CrossOrigin(origins = "*")
public class ObraController {

	@Autowired
	private ObraService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<Page<ObraPageResponseDto>> getObras(
			@PathParam(value = "validadasProfessora") Boolean validadasProfessora, 
			@PathParam(value = "validadasDph") Boolean validadasDph,
			Pageable pageable) {
		validadasProfessora = Objects.nonNull(validadasProfessora) ? validadasProfessora : false;
		validadasDph = Objects.nonNull(validadasDph) ? validadasDph : false;
		Page<Obra> obras = service.readObras(pageable, validadasProfessora, validadasDph);
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
		Endereco endereco = mapper.map(obraDto.enderecoObra(), Endereco.class);
		List<String> referenciasUrls = obraDto.referenciasObra();
		service.createObra(obra, obraDto.arquitetosId(), obraDto.construtoraId(), endereco, referenciasUrls);
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

	@PutMapping("/validacaoProfessora/{id}")
	public ResponseEntity<ObraResponseDto> validacaoProfessora(@PathVariable Integer id) {
		Obra obra = service.validacaoProfessora(id);
		ObraResponseDto response = mapper.map(obra, ObraResponseDto.class);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/validacaoDPH/{id}")
	public ResponseEntity<ObraResponseDto> validacaoDPH(@PathVariable Integer id) {
		Obra obra = service.validacaoDPH(id);
		ObraResponseDto response = mapper.map(obra, ObraResponseDto.class);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/enums/{enumTipo}")
	public ResponseEntity<List<String>> getOpcoesEnum(@PathVariable String enumTipo) {
		List<String> opcoes;

		switch (enumTipo) {
			case "obraStatus":
				opcoes = Arrays.asList(ObraStatus.values()).stream().map(value -> value.toString()).toList();
				break;
			case "enderecoTipo":
				opcoes = Arrays.asList(EnderecoTipo.values()).stream().map(value -> value.toString()).toList();
				break;
			case "enderecoTitulo":
				opcoes = Arrays.asList(EnderecoTitulo.values()).stream().map(value -> value.toString()).toList();
				break;
			default:
				throw new EntityNotFoundException("Valor informado não pôde ser mapeado.");
		}

		return ResponseEntity.ok(opcoes);
	}

}
