package com.example.api_tickets.models.requests;

import lombok.Data;

@Data
public class TicketUpdate {
    private int id;
    private Integer idUsuario;
    private String titulo;
    private String descripcion;
    private String estado;
    private String fechaCreacion; 
}
