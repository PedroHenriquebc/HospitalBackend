package com.project.hospital.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "Prescreve")
public class Prescreve {
	
	
	@Column(name = "Dosagem")
	private Integer dosagem;
	
	@Column(name = "Horario")
	private Time horario;
	
	@Column(name = "Suspender")
	private Integer supender;

	public Prescreve() {
		super();
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