package com.example.api_contenidos.models.requests;

import lombok.Data;

@Data
public class ContenidoUpdate {
    private int id;
    private String titulo;
    private String tipo;
    private String urlRecurso;
    private Integer idCurso; 
}
