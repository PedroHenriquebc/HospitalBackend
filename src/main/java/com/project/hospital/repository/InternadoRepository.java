package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.hospital.model.Internado;
import com.project.hospital.model.Paciente;
import com.project.hospital.model.Leito;

@Repository
public interface InternadoRepository extends JpaRepository<Internado, Long> {
	List<Paciente> findByNameContainingIgnoreCase(String name);
	
	List<Leito> findByNameContainingIgnoreCase(String name);
}
