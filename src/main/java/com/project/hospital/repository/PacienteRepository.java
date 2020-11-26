package com.project.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	boolean existsById(Long id);

	Optional<Paciente> findById(Long id);

	Optional<Paciente> findByEmail(String email);
	
	Optional<Paciente> findByCpf(String cpf);
}


