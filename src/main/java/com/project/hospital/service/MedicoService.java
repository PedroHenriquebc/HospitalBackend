package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.MedicoRepository;

@Service
public class MedicoService {
	private MedicoRepository medicoRepository;

	public MedicoService(MedicoRepository medicoRepository) {
		super();
		this.medicoRepository = medicoRepository;
	}
	
}
