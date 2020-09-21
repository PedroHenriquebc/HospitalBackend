package com.project.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hospital.model.Leito;
import com.project.hospital.model.Unidade;
import com.project.hospital.repository.LeitoRepository;

@Service
public class LeitoService {

	private LeitoRepository leitoRepository;
	private UnidadeService unidadeSerivce;

	public LeitoService(LeitoRepository leitoRepository, UnidadeService unidadeSerivce) {
		super();
		this.leitoRepository = leitoRepository;
		this.unidadeSerivce = unidadeSerivce;
	}

	public List<Leito> findAll() {
		// TODO Auto-generated method stub
		return leitoRepository.findAll();
	}

	public Leito findById(Long id) {
		// TODO Auto-generated method stub
		return leitoRepository.findById(id).orElse(null);
	}

	public Leito save(Leito leito) {
		leito.setId(null);

		try {
			leito = leitoRepository.save(leito);

			Unidade unidade = unidadeSerivce.findById(leito.getUnidade().getId());
			leito.setUnidade(unidade);

			return leito;
		} catch (Exception e) {
			return null;
		}
	}
}
