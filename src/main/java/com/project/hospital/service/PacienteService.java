package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Paciente;
import com.project.hospital.repository.PacienteRepository;

@Service
public class PacienteService {
	
	private PacienteRepository pacienteRepository;

	public PacienteService(PacienteRepository pacienteRepository) {
		super();
		this.pacienteRepository = pacienteRepository;
	}
	public List<Paciente> findAll(){
		return pacienteRepository.findAll();
	}

	public Paciente findById(Integer id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	public Paciente save(Paciente paciente) {
		paciente.setId(null);
		return internalSave(paciente);
	}

	private Paciente internalSave(Paciente paciente) {
		try {
			return pacienteRepository.save(paciente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente update(Paciente paciente) {
		Integer id = paciente.getId();
		if(id == null) {
			return null;
		}
		if(!pacienteRepository.existsById(id)) {
			return null;
		}
		return internalSave(paciente);
	}

	public void deleteById(Integer id) {
		try {
			pacienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		pacienteRepository.deleteAllInBatch();
	}

}
