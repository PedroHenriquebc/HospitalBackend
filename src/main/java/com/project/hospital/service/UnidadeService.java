package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Unidade;
import com.project.hospital.repository.UnidadeRepository;

@Service
public class UnidadeService {
	private UnidadeRepository unidadeRepository;

	public UnidadeService(UnidadeRepository unidadeRepository) {
		super();
		this.unidadeRepository = unidadeRepository;
	}
	
	public List<Unidade> findAll(){
		return unidadeRepository.findAll();
	}

	public Unidade findById(Long id) {
		return unidadeRepository.findById(id).orElse(null);
	}

	public Unidade save(Unidade unidade) {
		unidade.setId(null);
		return internalSave(unidade);
	}

	private Unidade internalSave(Unidade unidade) {
		try {
			return unidadeRepository.save(unidade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Unidade update(Unidade unidade) {
		Long id = unidade.getId();
		if(id == null) {
			return null;
		}
		if(!unidadeRepository.existsById(id)) {
			return null;
		}
		return internalSave(unidade);
	}

	public void deleteById(Long id) {
		try {
			unidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		unidadeRepository.deleteAllInBatch();
	}

}
