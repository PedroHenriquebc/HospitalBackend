package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Terminologia;

@Repository
public interface TerminologiaRepository extends JpaRepository<Terminologia, Long>{

}
