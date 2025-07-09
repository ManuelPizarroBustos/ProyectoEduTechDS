package com.example.api_usuarios.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;

    
    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol;// ejemplo: ADMIN, ESTUDIANTE, INSTRUCTOR
}
    