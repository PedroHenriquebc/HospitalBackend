package com.project.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	boolean existsById(Long id);

	Optional<Funcionario> findById(Long id);
	Optional<Funcionario> findByEmail(String email);
}
