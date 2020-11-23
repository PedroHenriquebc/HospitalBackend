package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Terminologia;
import com.project.hospital.repository.TerminologiaRepository;

@Service
public class TerminologiaService {
		
	private TerminologiaRepository terminologiaRepository;

	public TerminologiaService(TerminologiaRepository terminologiaRepository) {
		super();
		this.terminologiaRepository = terminologiaRepository;
	}

	public Terminologia findById(Long id) {
		return terminologiaRepository.findById(id).orElse(null);
	}

	public List<Terminologia> findAll() {
		return terminologiaRepository.findAll();
	}

	public Terminologia update(Terminologia terminologia) {
		Long id = terminologia.getId();
		if(id == null) {
			return null;
		}
		if(!terminologiaRepository.existsById(id)) {
			return null;
		}
		return internalSave(terminologia);
	}

	private Terminologia internalSave(Terminologia terminologia) {
		try {
			return terminologiaRepository.save(terminologia);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void deleteById(Long id) {
		try {
			terminologiaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public Terminologia save(Terminologia terminologia) {
		terminologia.setId(null);
		return internalSave(terminologia);
	}
}
