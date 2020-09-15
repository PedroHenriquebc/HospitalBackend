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
	
		
		
}