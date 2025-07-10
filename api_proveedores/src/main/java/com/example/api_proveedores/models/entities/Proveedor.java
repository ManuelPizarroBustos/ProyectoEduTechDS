package com.example.api_proveedores.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;

    
    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String servicio; // Ej: Hosting, SaaS, Hardware
}
    