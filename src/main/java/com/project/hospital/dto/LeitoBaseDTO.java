package com.project.hospital.dto;

public class LeitoBaseDTO {

	private Long id;
	private String codigo;
	private UnidadeBaseDTO unidade;

	public LeitoBaseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public UnidadeBaseDTO getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeBaseDTO unidade) {
		this.unidade = unidade;
	}

}
