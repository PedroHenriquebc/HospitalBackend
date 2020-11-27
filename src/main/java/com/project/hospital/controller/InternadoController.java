package com.project.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.project.hospital.model.Internado;
import com.project.hospital.service.InternadoService;

@RestController
@RequestMapping(path = "/internado", produces = MediaType.APPLICATION_JSON_VALUE)
public class InternadoController {
	private InternadoService internadoService;

	public InternadoController(InternadoService internadoService) {
		super();
		this.internadoService = internadoService;
	}
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Internado>> getInternado(){
		List<Internado> internado = internadoService.findAll();
		return new ResponseEntity<>(internado, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value = "/{internado_id}")
	public ResponseEntity<Internado> getInternado(@PathVariable(value = "internado_id") Long id){
		Internado internado= internadoService.findById(id);
		if(internado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(internado, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Internado> createInternado(@RequestBody Internado internado) {
		Internado internadoSaved = internadoService.save(internado);
		if (internadoSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(internadoSaved, HttpStatus.CREATED);
		}
	}
	@CrossOrigin
	@PutMapping(value = "/{internado_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Internado> updateInternado(@PathVariable(value = "internado_id") Long id, @RequestBody Internado internado) {
		internado.setId(id);
		Internado internadoSaved = internadoService.update(internado);
		if (internadoSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(internadoSaved, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@DeleteMapping(value = "/{internado_id}")
	public ResponseEntity<Void> deleteInternado(@PathVariable(value = "internado_id") Long id){
		internadoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<Void> deleteInternado(){
		internadoService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
