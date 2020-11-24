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

import com.project.hospital.model.Terminologia;
import com.project.hospital.service.TerminologiaService;

@RestController
@RequestMapping(path = "/terminologia", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminologiaController {
	
	private TerminologiaService terminologiaService;
	
	@GetMapping
	public ResponseEntity<List<Terminologia>> getTerminologia(){
		List<Terminologia> terminologia = terminologiaService.findAll();
		return new ResponseEntity<>(terminologia, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{terminologia_id}")
	public ResponseEntity<Terminologia> getTerminologia(@PathVariable(value = "terminologia_id") Long id){
		Terminologia terminologia= terminologiaService.findById(id);
		if(terminologia == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(terminologia, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/{terminologia_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Terminologia> updateTerminologia(@PathVariable(value = "terminologia_id") Long id, @RequestBody Terminologia terminologia) {
		terminologia.setId(id);
		Terminologia terminologiaSaved = terminologiaService.update(terminologia);
		if (terminologiaSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(terminologiaSaved, HttpStatus.OK);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Terminologia> createTerminologia(@RequestBody Terminologia terminologia) {
		Terminologia terminologiaSaved = terminologiaService.save(terminologia);
		if (terminologiaSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(terminologiaSaved, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(value = "/{terminologia_id}")
	public ResponseEntity<Void> deleteTerminologia(@PathVariable(value = "terminologia_id") Long id){
		terminologiaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
