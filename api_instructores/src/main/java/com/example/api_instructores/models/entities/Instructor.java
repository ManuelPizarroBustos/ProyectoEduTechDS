package com.example.api_instructores.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false,unique = true)
    private String email;

}
    