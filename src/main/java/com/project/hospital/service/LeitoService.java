package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.LeitoRepository;

@Service
public class LeitoService {
	
	private LeitoRepository leitoRepository;

	public LeitoService(LeitoRepository leitoRepository) {
		super();
		this.leitoRepository = leitoRepository;
	}
}
