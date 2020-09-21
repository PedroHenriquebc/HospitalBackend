package com.project.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital.dto.UnidadeBaseDTO;
import com.project.hospital.mapper.UnidadeMapper;
import com.project.hospital.model.Unidade;
import com.project.hospital.service.UnidadeService;

@RestController
@RequestMapping(path = "/unidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeController {

	private UnidadeService unidadeService;
	private UnidadeMapper mapper;

	public UnidadeController(UnidadeService unidadeService, UnidadeMapper mapper) {
		super();
		this.unidadeService = unidadeService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<UnidadeBaseDTO>> getAllUnidades() {
		List<Unidade> unidades = unidadeService.findAll();

		return new ResponseEntity<>(mapper.toUnidadeBaseDTO(unidades), HttpStatus.OK);
	}

	@GetMapping(value = "/{unidade_id}")
	public ResponseEntity<UnidadeBaseDTO> getUnidadesById(@PathVariable(value = "unidade_id") Long id) {
		Unidade unidade = unidadeService.findById(id);
		if (unidade == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toUnidadeBaseDTO(unidade), HttpStatus.OK);
		}
	}

}
