package com.gerente.repository;

import com.gerente.model.entity.Ambulancia;
import com.gerente.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanciaRepository extends JpaRepository<Ambulancia, Long> {
}
