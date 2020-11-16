package com.project.hospital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "terminologia")
public class Terminologia {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String codigo;
	
	@Column 
	private String sigla;

	@Column
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "terminologia", fetch = FetchType.LAZY)
	private List<Medicamento> medicamentos;
	
	
	public Terminologia(Long id, String codigo, String sigla, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.sigla = sigla;
		this.descricao = descricao;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
