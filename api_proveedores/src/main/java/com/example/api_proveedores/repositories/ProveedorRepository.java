package com.example.api_proveedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_proveedores.models.entities.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
    
}
