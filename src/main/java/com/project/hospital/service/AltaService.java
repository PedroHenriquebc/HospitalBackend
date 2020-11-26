package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Alta;
import com.project.hospital.repository.AltaRepository;

@Service
public class AltaService {
	private AltaRepository altaRepository;

	public AltaService(AltaRepository altaRepository) {
		super();
		this.altaRepository = altaRepository;
	}
	
	public List<Alta> findAll(){
		return altaRepository.findAll();
	}

	public Alta findById(Long id) {
		return altaRepository.findById(id).orElse(null);
	}

	public Alta save(Alta alta) {
		alta.setId(null);
		return internalSave(alta);
	}

	private Alta internalSave(Alta alta) {
		try {
			return altaRepository.save(alta);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Alta update(Alta alta) {
		Long id = alta.getId();
		if(id == null) {
			return null;
		}
		if(!altaRepository.existsById(id)) {
			return null;
		}
		return internalSave(alta);
	}

	public void deleteById(Long id) {
		try {
			altaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		altaRepository.deleteAllInBatch();
	}

}

