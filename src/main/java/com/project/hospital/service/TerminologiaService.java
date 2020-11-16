package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.TerminologiaRepository;

@Service
public class TerminologiaService {
		
	private TerminologiaRepository terminologiaRepository;

	public TerminologiaService(TerminologiaRepository terminologiaRepository) {
		super();
		this.terminologiaRepository = terminologiaRepository;
	}
	
}
