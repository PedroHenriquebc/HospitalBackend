package com.project.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public UnidadeController(UnidadeService unidadeService) {
		super();
		this.unidadeService = unidadeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Unidade>> getUnidades(){
		List<Unidade> unidades = unidadeService.findAll();
		return new ResponseEntity<>(unidades, HttpStatus.OK);
	}

	@GetMapping(value = "/{unidade_id}")
	public ResponseEntity<Unidade> getUnidade(@PathVariable(value = "unidade_id") Long id){
		Unidade unidade = unidadeService.findById(id);
		if(unidade == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(unidade, HttpStatus.OK);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Unidade> createUnidade(@RequestBody Unidade unidade) {
		Unidade unidadeSaved = unidadeService.save(unidade);
		if (unidadeSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(unidadeSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{unidade_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Unidade> updateUnidade(@PathVariable(value = "unidade_id") Long id, @RequestBody Unidade unidade) {
		unidade.setId(id);
		Unidade unidadeSaved = unidadeService.update(unidade);
		if (unidadeSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(unidadeSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{unidade_id}")
	public ResponseEntity<Void> deleteUnidade(@PathVariable(value = "unidade_id") Long id){
		unidadeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteUnidades(){
		unidadeService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
