package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hospital.model.Cbos;

@Repository
public interface CbosRepository extends JpaRepository<Cbos, Long>{

}
