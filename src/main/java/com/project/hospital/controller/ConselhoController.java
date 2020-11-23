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

import com.project.hospital.model.Conselho;
import com.project.hospital.service.ConselhoService;

@RestController
@RequestMapping(path = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConselhoController {

	private ConselhoService conselhoService;

	public ConselhoController(ConselhoService conselhoService) {
		super();
		this.conselhoService = conselhoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Conselho>> getConselho(){
		List<Conselho> conselho = conselhoService.findAll();
		return new ResponseEntity<>(conselho, HttpStatus.OK);
	}

	@GetMapping(value = "/{conselho_id}")
	public ResponseEntity<Conselho> getConselho(@PathVariable(value = "conselho_id") Long id){
		Conselho conselho= conselhoService.findById(id);
		if(conselho == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(conselho, HttpStatus.OK);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conselho> createConselho(@RequestBody Conselho conselho) {
		Conselho conselhoSaved = conselhoService.save(conselho);
		if (conselhoSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(conselhoSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{conselho_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conselho> updateConselho(@PathVariable(value = "conselho_id") Long id, @RequestBody Conselho conselho) {
		conselho.setId(id);
		Conselho conselhoSaved = conselhoService.update(conselho);
		if (conselhoSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(conselhoSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{conselho_id}")
	public ResponseEntity<Void> deleteConselho(@PathVariable(value = "conselho_id") Long id){
		conselhoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
