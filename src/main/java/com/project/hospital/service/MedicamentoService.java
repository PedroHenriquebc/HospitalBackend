package com.project.hospital.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.hospital.model.Medicamento;
import com.project.hospital.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

	private MedicamentoRepository medicamentoRepository;

	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		super();
		this.medicamentoRepository = medicamentoRepository;
	}

	public List<Medicamento> findAll() {
		return medicamentoRepository.findAll();
	}

	public Medicamento save(Medicamento medicamento) {
		medicamento.setId(null);
		return internalSave(medicamento);
	}

	private Medicamento internalSave(Medicamento medicamento) {
		try {
			return medicamentoRepository.save(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteById(Integer id) {
		try {
			medicamentoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public Medicamento update(Medicamento medicamento) {
		Integer id = medicamento.getId();
		if(id == null) {
			return null;
		}
		if(!medicamentoRepository.existsById(id)) {
			return null;
		}
		return internalSave(medicamento);
	}

}
