package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.PacienteRepository;

@Service
public class PacienteService {
	
	private PacienteRepository pacienteRepository;

	public PacienteService(PacienteRepository pacienteRepository) {
		super();
		this.pacienteRepository = pacienteRepository;
	}
}
