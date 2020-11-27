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

import com.project.hospital.model.Medico;
import com.project.hospital.service.MedicoService;

@RestController
@RequestMapping(path = "/medico", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicoController {
	private MedicoService medicoService;

	public MedicoController(MedicoService medicoService) {
		super();
		this.medicoService = medicoService;
	}
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Medico>> getMedico(){
		List<Medico> medico = medicoService.findAll();
		return new ResponseEntity<>(medico, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value = "email/{medico_email}")
	public ResponseEntity<Medico> getMedico(@PathVariable(value = "medico_email") String email){
		Medico medico= medicoService.findByEmail(email);
		if(medico == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(medico, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@GetMapping(value = "/{medico_id}")
	public ResponseEntity<Medico> getInternado(@PathVariable(value = "medico_id") Long id){
		Medico medico= medicoService.findById(id);
		if(medico == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(medico, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PutMapping(value = "/{medico_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> updateMedico(@PathVariable(value = "medico_id") Long id, @RequestBody Medico medico) {
		medico.setId(id);
		Medico medicoSaved = medicoService.update(medico);
		if (medicoSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(medicoSaved, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
		Medico medicoSaved = medicoService.save(medico);
		if (medicoSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(medicoSaved, HttpStatus.CREATED);
		}
	}
	@CrossOrigin
	@DeleteMapping(value = "/{medico_id}")
	public ResponseEntity<Void> deleteMedico(@PathVariable(value = "medico_id") Integer id){
		medicoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
