package com.project.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	boolean existsById(Long id);

	Optional<Medico> findById(Long id);

	Optional<Medico> findByEmail(String email);
}