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

import com.project.hospital.model.Setor;
import com.project.hospital.service.SetorService;

@RestController
@RequestMapping(path = "/setor", produces = MediaType.APPLICATION_JSON_VALUE)
public class SetorController {
	private SetorService setorService;

	public SetorController(SetorService setorService) {
		super();
		this.setorService = setorService;
	}
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Setor>> getSetor(){
		List<Setor> setor = setorService.findAll();
		return new ResponseEntity<>(setor, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value = "/{setor_id}")
	public ResponseEntity<Setor> getSetor(@PathVariable(value = "setor_id") Long id){
		Setor setor= setorService.findById(id);
		if(setor == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(setor, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Setor> createSetor(@RequestBody Setor setor) {
		Setor setorSaved = setorService.save(setor);
		if (setorSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(setorSaved, HttpStatus.CREATED);
		}
	}
	@CrossOrigin
	@PutMapping(value = "/{setor_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Setor> updateSetor(@PathVariable(value = "setor_id") Long id, @RequestBody Setor setor) {
		setor.setId(id);
		Setor setorSaved = setorService.update(setor);
		if (setorSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(setorSaved, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@DeleteMapping(value = "/{setor_id}")
	public ResponseEntity<Void> deleteSetor(@PathVariable(value = "setor_id") Long id){
		setorService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<Void> deleteSetor(){
		setorService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
