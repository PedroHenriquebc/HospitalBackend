package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Cbos;
import com.project.hospital.repository.CbosRepository;

@Service
public class CbosService {
	private CbosRepository cbosRepository;

	public CbosService(CbosRepository cbosRepository) {
		super();
		this.cbosRepository = cbosRepository;
	}
	
	public List<Cbos> findAll(){
		return cbosRepository.findAll();
	}

	public Cbos save(Cbos cbos) {
		cbos.setId(null);
		return internalSave(cbos);
	}

	private Cbos internalSave(Cbos cbos) {
		try {
			return cbosRepository.save(cbos);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cbos update(Cbos cbos) {
		Long id = cbos.getId();
		if(id == null) {
			return null;
		}
		if(!cbosRepository.existsById(id)) {
			return null;
		}
		return internalSave(cbos);
	}

	public void deleteById(Long id) {
		try {
			cbosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

}