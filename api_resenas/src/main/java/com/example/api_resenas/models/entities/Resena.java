package com.example.api_resenas.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "resena")
public class Resena {

    @Id
    private int id;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false)
    private Integer idCurso;

    @Column(nullable = false)
    private Integer calificacion;
    
    @Column(nullable = false)
    private String comentario;

}
    