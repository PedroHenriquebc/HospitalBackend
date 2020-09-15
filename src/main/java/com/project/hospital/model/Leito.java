package com.project.hospital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leito")
public class Leito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String codigo;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Unidade unidade;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leito", cascade = CascadeType.ALL)
	private List<Internado> internados;

	public Leito() {
		super();
	}

	public List<Internado> getInternados() {
		return internados;
	}

	public void setInternados(List<Internado> internados) {
		this.internados = internados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
