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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String name;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cbos cbos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Conselho conselho;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medico",fetch = FetchType.LAZY)
	private List<Prescreve> prescreve;
	
	public Medico() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
