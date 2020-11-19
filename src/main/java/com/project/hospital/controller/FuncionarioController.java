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

import com.project.hospital.model.Funcionario;
import com.project.hospital.service.FuncionarioService;

@RestController
@RequestMapping(path = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {
	private FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		super();
		this.funcionarioService = funcionarioService;
	}
	@GetMapping
	public ResponseEntity<List<Funcionario>> getFuncionarios(){
		List<Funcionario> funcionarios = funcionarioService.findAll();
		return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	}

	@GetMapping(value = "/{funcionario_id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable(value = "funcionario_id") Long id){
		Funcionario funcionario = funcionarioService.findById(id);
		if(funcionario == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioSaved = funcionarioService.save(funcionario);
		if (funcionarioSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(funcionarioSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{funcionario_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "funcionario_id") Long id, @RequestBody Funcionario funcionario) {
		funcionario.setId(id);
		Funcionario funcionarioSaved = funcionarioService.update(funcionario);
		if (funcionarioSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(funcionarioSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{funcionario_id}")
	public ResponseEntity<Void> deleteFuncionario(@PathVariable(value = "funcionario_id") Long id){
		funcionarioService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteFuncionarios(){
		funcionarioService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
