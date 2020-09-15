package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Leito;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {

}
