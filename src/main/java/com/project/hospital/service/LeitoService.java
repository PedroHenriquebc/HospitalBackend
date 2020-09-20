package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Leito;
import com.project.hospital.repository.LeitoRepository;

@Service
public class LeitoService {
	
	private LeitoRepository leitoRepository;

	public LeitoService(LeitoRepository leitoRepository) {
		super();
		this.leitoRepository = leitoRepository;
	}

	public List<Leito> findAll() {
		// TODO Auto-generated method stub
		return leitoRepository.findAll();
	}

	public Leito findById(Long id) {
		// TODO Auto-generated method stub
		return leitoRepository.findById(id).orElse(null);
	}
}
