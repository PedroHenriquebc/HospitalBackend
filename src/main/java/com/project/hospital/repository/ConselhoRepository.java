package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Conselho;

@Repository
public interface ConselhoRepository extends JpaRepository<Conselho, Long>{

}
