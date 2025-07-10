package com.example.api_evaluaciones.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EvaluacionCreate {
    
    @NotBlank
    private int id; 

    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private Integer idUsuario;        

    @NotBlank
    private Integer idCurso; 
}
