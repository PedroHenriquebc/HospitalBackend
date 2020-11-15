package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Prescreve;

@Repository
public interface PrescreveRepository extends JpaRepository<Prescreve, Long> {
	
}
