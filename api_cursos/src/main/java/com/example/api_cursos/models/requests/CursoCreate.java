package com.example.api_cursos.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoCreate {
    
    
    private int id;

    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;

    @NotBlank
    private String categoria;

    
    private Integer idInstructor;   
}
