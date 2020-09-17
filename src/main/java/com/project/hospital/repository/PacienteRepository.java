package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
  
}


