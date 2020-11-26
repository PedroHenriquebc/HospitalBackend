package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Alta;

@Repository
public interface AltaRepository extends JpaRepository<Alta, Long>{

}
