package com.example.api_evaluaciones.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "evaluacion")
public class Evaluacion {

    @Id
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false)
    private Integer idCurso;
}
    