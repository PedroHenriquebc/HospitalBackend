package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Setor;
import com.project.hospital.repository.SetorRepository;

@Service
public class SetorService {
	private SetorRepository setorRepository;

	public SetorService(SetorRepository setorRepository) {
		super();
		this.setorRepository = setorRepository;
	}
	
	public List<Setor> findAll(){
		return setorRepository.findAll();
	}
}