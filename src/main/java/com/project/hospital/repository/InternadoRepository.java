package com.project.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.hospital.model.Internado;

@Repository
public interface InternadoRepository extends JpaRepository<Internado, Long> {

}
