package com.example.api_inscripciones.models.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Integer usuarioId;

    @Column(nullable = false,unique = true)
    private Integer cursoId;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String fechaInscripcion;
}
    