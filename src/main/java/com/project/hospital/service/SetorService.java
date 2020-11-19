package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Setor;
import com.project.hospital.repository.SetorRepository;

@Service
public class SetorService {
	private SetorRepository setorRepository;

	public SetorService(SetorRepository setorRepository) {
		super();
		this.setorRepository = setorRepository;
	}
	
	public List<Setor> findAll(){
		return setorRepository.findAll();
	}

	public Setor findById(Long id) {
		return setorRepository.findById(id).orElse(null);
	}

	public Setor save(Setor setor) {
		setor.setId(null);
		return internalSave(setor);
	}

	private Setor internalSave(Setor setor) {
		try {
			return setorRepository.save(setor);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Setor update(Setor setor) {
		Long id = setor.getId();
		if(id == null) {
			return null;
		}
		if(!setorRepository.existsById(id)) {
			return null;
		}
		return internalSave(setor);
	}

	public void deleteById(Long id) {
		try {
			setorRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		setorRepository.deleteAllInBatch();
	}

}