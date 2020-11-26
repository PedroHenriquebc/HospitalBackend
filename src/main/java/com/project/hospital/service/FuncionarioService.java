package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
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

	public Funcionario findById(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario findByEmail(String email) {
		return funcionarioRepository.findByEmail(email).orElse(null);
	}

	public Funcionario save(Funcionario funcionario) {
		funcionario.setId(null);
		return internalSave(funcionario);
	}

	private Funcionario internalSave(Funcionario funcionario) {
		try {
			return funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Funcionario update(Funcionario funcionario) {
		Long id = funcionario.getId();
		if(id == null) {
			return null;
		}
		if(!funcionarioRepository.existsById(id)) {
			return null;
		}
		return internalSave(funcionario);
	}

	public void deleteById(Long id) {
		try {
			funcionarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		funcionarioRepository.deleteAllInBatch();
	}

}