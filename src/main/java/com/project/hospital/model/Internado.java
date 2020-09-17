package com.project.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "internado")
public class Internado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data_internacao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date data_alta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Leito leito;

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Internado() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getData_internacao() {
		return data_internacao;
	}

	public void setData_internacao(Date data_internacao) {
		this.data_internacao = data_internacao;
	}

	public Date getData_alta() {
		return data_alta;
	}

	public void setData_alta(Date data_alta) {
		this.data_alta = data_alta;
	}
}
