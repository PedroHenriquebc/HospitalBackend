package com.project.hospital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="unidade")
public class Unidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)	
	private String nome; 
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false, unique = true)	
	private String inscricao_estadual;
	
	@Column(nullable = false)
	private String telefone;
	
	// Unidade com vários leitos
	@OneToMany(cascade=CascadeType.ALL, mappedBy="unidade", fetch=FetchType.LAZY)
	private List<Leito> leitos;
	
	public Unidade() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public List<Leito> getLeitos() {
		return leitos;
	}

	public void setLeitos(List<Leito> leitos) {
		this.leitos = leitos;
	}
	
	
}
