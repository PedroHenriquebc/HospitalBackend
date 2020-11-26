package com.project.hospital.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "alta")
public class Alta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@OneToOne
	private Internado internado;
	
	@OneToOne
	private Medico medico;
	
	public Alta() {
	}

	public Alta(Date data, Internado internado, Medico medico) {
		this.data = data;
		this.internado = internado;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Internado getInternado() {
		return internado;
	}

	public void setInternado(Internado internado) {
		this.internado = internado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		return "Alta [data=" + data + ", medico=" + medico + "]";
	}
}
