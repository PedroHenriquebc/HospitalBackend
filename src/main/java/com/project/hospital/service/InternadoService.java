package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Internado;
import com.project.hospital.repository.InternadoRepository;

@Service
public class InternadoService {
	
	private InternadoRepository internadoRepository;

	public InternadoService(InternadoRepository internadoRepository) {
		super();
		this.internadoRepository = internadoRepository;
	}
	
	public List<Internado> findAll(){
		return internadoRepository.findAll();
	}

	public Internado findById(Long id) {
		return internadoRepository.findById(id).orElse(null);
	}

	public Internado save(Internado internado) {
		internado.setId(null);
		return internalSave(internado);
	}

	private Internado internalSave(Internado internado) {
		try {
			return internadoRepository.save(internado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Internado update(Internado internado) {
		Long id = internado.getId();
		if(id == null) {
			return null;
		}
		if(!internadoRepository.existsById(id)) {
			return null;
		}
		return internalSave(internado);
	}

	public void deleteById(Long id) {
		try {
			internadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		internadoRepository.deleteAllInBatch();
	}

}

