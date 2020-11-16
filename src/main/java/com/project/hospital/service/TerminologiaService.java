package com.project.hospital.service;

import org.springframework.stereotype.Service;
import com.project.hospital.repository.TermologiaRepository;

@Service
public class TermologiaService {
		
	private TermologiaRepository termologiaRepository;

	public TermologiaService(TermologiaRepository termologiaRepository) {
		super();
		this.termologiaRepository = termologiaRepository;
	}
	
}
