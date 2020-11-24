package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Leito;
//import com.project.hospital.model.Unidade;
import com.project.hospital.repository.LeitoRepository;

@Service
public class LeitoService {
	private LeitoRepository leitoRepository;

	public LeitoService(LeitoRepository leitoRepository) {
		super();
		this.leitoRepository = leitoRepository;
	}
	
	public List<Leito> findAll(){
		return leitoRepository.findAll();
	}

	public Leito findById(Long id) {
		return leitoRepository.findById(id).orElse(null);
	}

	public Leito save(Leito leito) {
		leito.setId(null);
		return internalSave(leito);
	}

	private Leito internalSave(Leito leito) {
		try {
			return leitoRepository.save(leito);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Leito update(Leito leito) {
		Long id = leito.getId();
		if(id == null) {
			return null;
		}
		if(!leitoRepository.existsById(id)) {
			return null;
		}
		return internalSave(leito);
	}

	public void deleteById(Long id) {
		try {
			leitoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		leitoRepository.deleteAllInBatch();
	}

}