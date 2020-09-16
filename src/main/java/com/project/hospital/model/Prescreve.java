package com.project.hospital.model;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Prescreve")
public class Prescreve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Dosagem")
	private Integer dosagem;
	
	@Column(name = "Horario")
	private Time horario;
	
	@Column(name = "Suspender")
	private Integer supender;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Medico medico;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Medicamento medicamento;

	public Prescreve() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDosagem() {
		return dosagem;
	}

	public void setDosagem(Integer dosagem) {
		this.dosagem = dosagem;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Integer getSupender() {
		return supender;
	}

	public void setSupender(Integer supender) {
		this.supender = supender;
	}
	
	
		
}