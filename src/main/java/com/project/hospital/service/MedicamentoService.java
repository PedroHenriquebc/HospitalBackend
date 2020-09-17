package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	
	private MedicamentoRepository medicamentoRepository;

	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		super();
		this.medicamentoRepository = medicamentoRepository;
	}
	
		
}
