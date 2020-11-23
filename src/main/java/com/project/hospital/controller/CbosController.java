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

import com.project.hospital.model.Cbos;
import com.project.hospital.service.CbosService;

@RestController
@RequestMapping(path = "/internado", produces = MediaType.APPLICATION_JSON_VALUE)
public class CbosController {
	private CbosService cbosService;

	public CbosController(CbosService cbosService) {
		super();
		this.cbosService = cbosService;
	}
	
	@GetMapping
	public ResponseEntity<List<Cbos>> getCbos(){
		List<Cbos> cbos = cbosService.findAll();
		return new ResponseEntity<>(cbos, HttpStatus.OK);
	}

/*	@GetMapping(value = "/{cbos_codigo}")
	public ResponseEntity<Cbos> getCbos(@PathVariable(value = "cbos_codigo") String codigo){
		Cbos cbos= cbosService.findByCodigo(codigo);
		if(cbos == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(cbos, HttpStatus.OK);
		}
	}*/

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cbos> createCbos(@RequestBody Cbos cbos) {
		Cbos cbosSaved = cbosService.save(cbos);
		if (cbosSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(cbosSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{cbos_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cbos> updateCbos(@PathVariable(value = "cbos_id") Long id, @RequestBody Cbos cbos) {
		cbos.setId(id);
		Cbos cbosSaved = cbosService.update(cbos);
		if (cbosSaved == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(cbosSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{cbos_id}")
	public ResponseEntity<Void> deleteCbos(@PathVariable(value = "cbos_id") Long id){
		cbosService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
