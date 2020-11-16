package com.project.hospital.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false)
	private Sexo sexo;

	@Column(name = "data_nascimento", nullable = false)
	private Date data_nascimento;
	
	@Column(name = "senha", nullable = false)
	private String senha;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Internado> internados;

	public Paciente() {
		super();
	}

	public List<Internado> getInternados() {
		return internados;
	}

	public void setInternados(List<Internado> internados) {
		this.internados = internados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
}
