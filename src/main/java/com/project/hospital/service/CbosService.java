package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Cbos;
import com.project.hospital.repository.CbosRepository;

@Service
public class CbosService {
	private CbosRepository cbosRepository;

	public CbosService(CbosRepository cbosRepository) {
		super();
		this.cbosRepository = cbosRepository;
	}
	
	public List<Cbos> findAll(){
		return cbosRepository.findAll();
	}
}