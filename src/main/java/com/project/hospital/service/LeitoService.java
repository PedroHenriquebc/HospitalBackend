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
	//private UnidadeService unidadeSerivce;

	//public LeitoService(LeitoRepository leitoRepository, UnidadeService unidadeSerivce) {
	public LeitoService(LeitoRepository leitoRepository) {
		super();
		this.leitoRepository = leitoRepository;
		//this.unidadeSerivce = unidadeSerivce;
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

	
	/*
	public List<Leito> findAll() {
		// TODO Auto-generated method stub
		return leitoRepository.findAll();
	}

	public Leito findById(Long id) {
		// TODO Auto-generated method stub
		return leitoRepository.findById(id).orElse(null);
	}

	public Leito internalSave(Leito leito) {
		try {
			leito = leitoRepository.save(leito);

			Unidade unidade = unidadeSerivce.findById(leito.getUnidade().getId());
			leito.setUnidade(unidade);

			return leito;
		} catch (Exception e) {
			return null;
		}
	}

	public Leito save(Leito leito) {
		leito.setId(null);

		return internalSave(leito);
	}

	public Leito update(Leito leito) {
		Long id = leito.getId();

		if (id == null) {
			return null;
		}

		boolean exist = leitoRepository.existsById(id);

		if (!exist) {
			return null;
		}

		return internalSave(leito);
	}
	*/
}
