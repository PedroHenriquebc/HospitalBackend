package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.UnidadeRepository;

@Service
public class UnidadeService {

	private UnidadeRepository unidadeRepository;

	public UnidadeService(UnidadeRepository unidadeRepository) {
		super();
		this.unidadeRepository = unidadeRepository;
	}
}
