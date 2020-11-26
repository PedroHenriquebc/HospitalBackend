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

import com.project.hospital.model.Alta;
import com.project.hospital.service.AltaService;

@RestController
@RequestMapping(path = "/alta", produces = MediaType.APPLICATION_JSON_VALUE)
public class AltaController {
	private AltaService altaService;
	
	public AltaController(AltaService altaService) {
		super();
		this.altaService = altaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Alta>> getAltas(){
		List<Alta> altas = altaService.findAll();
		return new ResponseEntity<>(altas, HttpStatus.OK);
	}

	@GetMapping(value = "/{alta_id}")
	public ResponseEntity<Alta> getAlta(@PathVariable(value = "alta_id") Long id){
		Alta alta = altaService.findById(id);
		if(alta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(alta, HttpStatus.OK);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alta> createAlta(@RequestBody Alta alta) {
		Alta altaSaved = altaService.save(alta);
		if (altaSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(altaSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{alta_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alta> updateAlta(@PathVariable(value = "alta_id") Long id, @RequestBody Alta alta) {
		alta.setId(id);
		Alta altaSaved = altaService.update(alta);
		if (altaSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(altaSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{alta_id}")
	public ResponseEntity<Void> deleteAlta(@PathVariable(value = "alta_id") Long id){
		altaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAltas(){
		altaService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

