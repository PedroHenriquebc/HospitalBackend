package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Medico;
import com.project.hospital.repository.MedicoRepository;

@Service
public class MedicoService {
	private MedicoRepository medicoRepository;

	public MedicoService(MedicoRepository medicoRepository) {
		super();
		this.medicoRepository = medicoRepository;
	}

	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}

	public Medico update(Medico medico) {
		Long id = medico.getId();
		if(id == null) {
			return null;
		}
		if(!medicoRepository.existsById(id)) {
			return null;
		}
		return internalSave(medico);
	}

	private Medico internalSave(Medico medico) {
		try {
			return medicoRepository.save(medico);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Medico findById(Long id) {
		return medicoRepository.findById(id).orElse(null);
	}

	public Medico findByEmail(String email) {
		return medicoRepository.findByEmail(email).orElse(null);
	}

	public void deleteById(Integer id) {
		try {
			medicoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public Medico save(Medico medico) {
		medico.setId(null);
		return internalSave(medico);
	}	
}
