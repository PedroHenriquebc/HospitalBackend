package com.project.hospital.repository;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.hospital.model.Medicamento;
import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository <Medicamento, Integer> {
	List<Medicamento> findByValidade (Date validade);
}
