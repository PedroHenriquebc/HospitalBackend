package com.project.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "internado")
public class Internado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long id_paciente;

	@Column(nullable = false)
	private Long id_leito;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data_internacao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date data_alta;

	public Internado() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Long getId_leito() {
		return id_leito;
	}

	public void setId_leito(Long id_leito) {
		this.id_leito = id_leito;
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
