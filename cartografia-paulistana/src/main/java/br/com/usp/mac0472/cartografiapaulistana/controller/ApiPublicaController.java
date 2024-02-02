package br.com.usp.mac0472.cartografiapaulistana.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraValidadaPageResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.service.ObraService;

@RestController
@RequestMapping("api/publica")
@CrossOrigin(origins = "*")
public class ApiPublicaController {
	
	@Autowired
	private ObraService obraService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/obras")
	public ResponseEntity<Page<ObraValidadaPageResponseDto>> getValidadas(Pageable pageable) {
		Page<Obra> obras = obraService.getValidadas(pageable);
		List<ObraValidadaPageResponseDto> obrasDto = obras.stream()
				.map(obra -> mapper.map(obra, ObraValidadaPageResponseDto.class)).toList();
		Page<ObraValidadaPageResponseDto> response = PageableExecutionUtils.getPage(obrasDto, pageable,
				() -> obras.getTotalElements());
		return ResponseEntity.ok(response);
	}
	
}
