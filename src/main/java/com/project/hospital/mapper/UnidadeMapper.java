package com.project.hospital.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.hospital.dto.UnidadeBaseDTO;
import com.project.hospital.model.Unidade;

@Component
public class UnidadeMapper {

	private ModelMapper mapper;

	public UnidadeMapper() {
		super();
		this.mapper = new ModelMapper();
	}

	public List<UnidadeBaseDTO> toUnidadeBaseDTO(List<Unidade> unidades) {
		List<UnidadeBaseDTO> unidadeBaseDTO = new ArrayList<>();

		for (Unidade unidade : unidades) {
			UnidadeBaseDTO current = toUnidadeBaseDTO(unidade);
			unidadeBaseDTO.add(current);
		}

		return unidadeBaseDTO;
	}

	public UnidadeBaseDTO toUnidadeBaseDTO(Unidade unidade) {
		return mapper.map(unidade, UnidadeBaseDTO.class);
	}
}
