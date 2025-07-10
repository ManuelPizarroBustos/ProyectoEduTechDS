package com.example.api_evaluaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_evaluaciones.models.entities.Evaluacion;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion,Integer> {
    
}
