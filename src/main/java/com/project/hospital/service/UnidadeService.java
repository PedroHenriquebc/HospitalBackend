package com.project.hospital.service;

import java.util.List;

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

	public List<Unidade> findAll() {
		// TODO Auto-generated method stub
		return unidadeRepository.findAll();
	}

	public Unidade findById(Long id) {
		// TODO Auto-generated method stub
		return unidadeRepository.findById(id).orElse(null);
	}
}
