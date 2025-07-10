package com.example.api_resenas.models.requests;

import lombok.Data;

@Data
public class ResenaUpdate {
    private int id;
    private Integer idUsuario;
    private Integer idCurso;
    private Integer calificacion;
    private String comentario;
}
