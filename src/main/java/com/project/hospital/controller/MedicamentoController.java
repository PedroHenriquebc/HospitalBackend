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

import com.project.hospital.model.Medicamento;
import com.project.hospital.service.MedicamentoService;

@RestController
@RequestMapping(path = "/medicamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicamentoController {
	
	private MedicamentoService medicamentoService;
	
	public MedicamentoController(MedicamentoService medicamentoService) {
		super();
		this.medicamentoService = medicamentoService;
	}


	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Medicamento>> getMedicamento(){
		List<Medicamento> medicamento = medicamentoService.findAll();
		return new ResponseEntity<>(medicamento, HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping(value = "/{medicamento_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medicamento> updateMedicamento(@PathVariable(value = "internado_id") Integer id, @RequestBody Medicamento medicamento) {
		medicamento.setId(id);
		Medicamento medicamentoSaved = medicamentoService.update(medicamento);
		if (medicamentoSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(medicamentoSaved, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
		Medicamento medicamentoSaved = medicamentoService.save(medicamento);
		if (medicamentoSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(medicamentoSaved, HttpStatus.CREATED);
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{medicamento_id}")
	public ResponseEntity<Void> deleteMedicamento(@PathVariable(value = "medicamento_id") Integer id){
		medicamentoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
