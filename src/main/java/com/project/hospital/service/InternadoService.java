package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.InternadoRepository;

@Service
public class InternadoService {
	
	private InternadoRepository internadoRepository;

	public InternadoService(InternadoRepository internadoRepository) {
		super();
		this.internadoRepository = internadoRepository;
	}
}

