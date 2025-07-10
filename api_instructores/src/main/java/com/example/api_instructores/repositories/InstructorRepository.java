package com.example.api_instructores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_instructores.models.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
    
}
