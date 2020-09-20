package com.project.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital.model.Unidade;
import com.project.hospital.service.UnidadeService;

@RestController
@RequestMapping(path="/unidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeController {

	private UnidadeService unidadeService;

	public UnidadeController(UnidadeService unidadeService) {
		super();
		this.unidadeService = unidadeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Unidade>> getAllUnidades() {
		List<Unidade> unidades = unidadeService.findAll();
		
		return new ResponseEntity<>(unidades,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{unidade_id}")
	public ResponseEntity<Unidade> getUnidadesById(@PathVariable(value = "unidade_id") Long id) {
		Unidade unidade = unidadeService.findById(id);
		if (unidade == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(unidade,HttpStatus.OK);
		}
	}

}
