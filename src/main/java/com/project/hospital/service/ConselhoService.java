package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Conselho;
import com.project.hospital.repository.ConselhoRepository;

@Service
public class ConselhoService {
	private ConselhoRepository conselhoRepository;

	public ConselhoService(ConselhoRepository conselhoRepository) {
		super();
		this.conselhoRepository = conselhoRepository;
	}
	
	public List<Conselho> findAll(){
		return conselhoRepository.findAll();
	}

	public Conselho findById(Long id) {
		return conselhoRepository.findById(id).orElse(null);
	}

	public Conselho save(Conselho conselho) {
		conselho.setId(null);
		return internalSave(conselho);
	}

	private Conselho internalSave(Conselho conselho) {
		try {
			return conselhoRepository.save(conselho);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Conselho update(Conselho conselho) {
		Long id = conselho.getId();
		if(id == null) {
			return null;
		}
		if(!conselhoRepository.existsById(id)) {
			return null;
		}
		return internalSave(conselho);
	}

	public void deleteById(Long id) {
		try {
			conselhoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
	
	
}
