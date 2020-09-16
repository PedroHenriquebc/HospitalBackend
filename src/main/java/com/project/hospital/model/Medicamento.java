package com.project.hospital.model;

import java.util.Date;
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
@Table(name= "Medicamento")
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "validade")
	private Date validade;
	
	/*
	 
	 mappedBy = "medicamento"
	 medicamento é o nome do campo presente na classe Prescreve: "private Medicamento medicamento;"
	 
	 */
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "medicamento", fetch = FetchType.LAZY)
	private List<Prescreve> prescrito;
	
	public Medicamento() {
		super();
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
	
		
}