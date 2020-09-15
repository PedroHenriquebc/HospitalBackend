package com.project.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String name;
	@Column(name = "crm", nullable = false)
	private String crm;
	@Column(name = "codigocbos", nullable = false)
	private String cbos_codigo;
	
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCbos_codigo() {
		return cbos_codigo;
	}

	public void setCbos_codigo(String cbos_codigo) {
		this.cbos_codigo = cbos_codigo;
	}
	
	
}
