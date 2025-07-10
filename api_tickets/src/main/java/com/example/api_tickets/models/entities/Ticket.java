package com.example.api_tickets.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    private int id;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private String estado;// Ej: ABIERTA, EN PROGRESO, CERRADA

    @Column(nullable = false)
    private String fechaCreacion; 
}
    