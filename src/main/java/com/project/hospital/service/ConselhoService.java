package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Conselho;
import com.project.hospital.repository.ConselhoRepository;

@Service
public class ConselhoService {
	private ConselhoRepository conselhoRepository;

	public ConselhoService(ConselhoRepository conselhoRepository) {
		super();
		this.conselhoRepository = conselhoRepository;
	}
	
	public List<Conselho> findAll(){
		return conselhoRepository.findAll();
	}
}
