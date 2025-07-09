package com.example.api_inscripciones.models.requests;

import lombok.Data;

@Data
public class InscripcionUpdate {
    private int id;

    private Integer usuarioId;
    private Integer cursoId;
    private String estado;
    private String fechaInscripcion;   
}
