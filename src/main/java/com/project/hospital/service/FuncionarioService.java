package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Funcionario;
import com.project.hospital.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		super();
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
}