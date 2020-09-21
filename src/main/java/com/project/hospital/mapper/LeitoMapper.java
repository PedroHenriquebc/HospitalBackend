package com.project.hospital.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.hospital.dto.LeitoBaseDTO;
import com.project.hospital.model.Leito;

@Component
public class LeitoMapper {

	private ModelMapper mapper;

	public LeitoMapper() {
		super();
		this.mapper = new ModelMapper();
	}
	
	public List<LeitoBaseDTO> toLeitoBaseDTO(List<Leito> leitos) {
		List<LeitoBaseDTO> leitoBaseDTO = new ArrayList<>();

		for (Leito leito : leitos) {
			LeitoBaseDTO current = toLeitoBaseDTO(leito);
			leitoBaseDTO.add(current);
		}

		return leitoBaseDTO;
	}

	public LeitoBaseDTO toLeitoBaseDTO(Leito leito) {
		return mapper.map(leito, LeitoBaseDTO.class);
	}
	
	public Leito toLeito(LeitoBaseDTO leito) {
		return mapper.map(leito, Leito.class);
	}
}
