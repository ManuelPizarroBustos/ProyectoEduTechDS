package com.example.api_tickets.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketCreate {
    
    @NotBlank
    private int id; 

    @NotBlank
    private Integer idUsuario;
    
    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String estado;        

    @NotBlank
    private String fechaCreacion; 
}
