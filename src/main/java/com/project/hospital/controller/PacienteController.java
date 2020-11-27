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

import com.project.hospital.model.Paciente;
import com.project.hospital.service.PacienteService;

@RestController
@RequestMapping(path = "/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
	private PacienteService pacienteService;

	public PacienteController(PacienteService pacienteService) {
		super();
		this.pacienteService = pacienteService;
	}
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Paciente>> getPaciente(){
		List<Paciente> paciente = pacienteService.findAll();
		return new ResponseEntity<>(paciente, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value = "/{paciente_id}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable(value = "paciente_id") Integer id){
		Paciente paciente = pacienteService.findById(id);
		if(paciente == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(paciente, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@GetMapping(value = "email/{paciente_email}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable(value = "paciente_email") String email){
		Paciente paciente = pacienteService.findByEmail(email);
		if(paciente == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(paciente, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@GetMapping(value = "cpf/{paciente_cpf}")
	public ResponseEntity<Paciente> getPaciente1(@PathVariable(value = "paciente_cpf") String cpf){
		Paciente paciente = pacienteService.findByCpf(cpf);
		if(paciente == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(paciente, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
		Paciente pacienteSaved = pacienteService.save(paciente);
		if (pacienteSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(pacienteSaved, HttpStatus.CREATED);
		}
	}
	@CrossOrigin
	@PutMapping(value = "/{paciente_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> updatePaciente(@PathVariable(value = "paciente_id") Integer id, @RequestBody Paciente paciente) {
		paciente.setId(id);
		Paciente pacienteSaved = pacienteService.update(paciente);
		if (pacienteSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(pacienteSaved, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@DeleteMapping(value = "/{paciente_id}")
	public ResponseEntity<Void> deletePaciente(@PathVariable(value = "paciente_id") Integer id){
		pacienteService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<Void> deletePaciente(){
		pacienteService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
