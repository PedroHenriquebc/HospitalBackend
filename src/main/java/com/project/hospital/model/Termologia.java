package com.project.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "termo")
public class Termologia {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String termo;

	@Column
	private String descrica;
	
	public Termologia() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDescrica() {
		return descrica;
	}
	public void setDescrica(String descrica) {
		this.descrica = descrica;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTermo() {
		return termo;
	}
	public void setTermo(String termo) {
		this.termo = termo;
	}
}
