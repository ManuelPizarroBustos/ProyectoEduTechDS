package com.example.api_resenas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_resenas.models.entities.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena,Integer> {
    
}
