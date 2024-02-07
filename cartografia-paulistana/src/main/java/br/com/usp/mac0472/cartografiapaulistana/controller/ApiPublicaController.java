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

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraPageResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import br.com.usp.mac0472.cartografiapaulistana.service.ObraService;
import br.com.usp.mac0472.cartografiapaulistana.utils.MapeadorUtil;

@RestController
@RequestMapping("api/publica")
@CrossOrigin(origins = "*")
public class ApiPublicaController {
	
	@Autowired
	private ObraService obraService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/obras")
	public ResponseEntity<Page<ObraPageResponseDto>> getValidadas(Pageable pageable) {
		Page<Obra> obras = obraService.readObras(pageable, true, true);
		List<ObraPageResponseDto> obrasDto = obras.stream()
				.map(obra -> MapeadorUtil.mapObraToPageResponse(obra, mapper)).toList();
		Page<ObraPageResponseDto> response = PageableExecutionUtils.getPage(obrasDto, pageable,
				() -> obras.getTotalElements());
		return ResponseEntity.ok(response);
	}
	
}
