package com.project.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital.model.Leito;
import com.project.hospital.service.LeitoService;

@RestController
@RequestMapping(path="/leito", produces = MediaType.APPLICATION_JSON_VALUE)
public class LeitoController {

	private LeitoService leitoService;

	public LeitoController(LeitoService leitoService) {
		super();
		this.leitoService = leitoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Leito>> getAllLeitos() {
		List<Leito> leitos = leitoService.findAll();
		
		return new ResponseEntity<>(leitos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{letio_id}")
	public ResponseEntity<Leito> getLeitoById(@PathVariable(value = "leito_id") Long id) {
		Leito leito = leitoService.findById(id);
		
		if (leito == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(leito, HttpStatus.OK);
		}
	}
	
}
