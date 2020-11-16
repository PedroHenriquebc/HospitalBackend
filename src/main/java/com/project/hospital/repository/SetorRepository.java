package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
