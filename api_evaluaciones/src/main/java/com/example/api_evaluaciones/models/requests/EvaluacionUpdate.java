package com.example.api_evaluaciones.models.requests;

import lombok.Data;

@Data
public class EvaluacionUpdate {
    private int id;
    private String titulo;
    private String descripcion;
    private Integer idUsuario;
    private Integer idCurso; 
}
