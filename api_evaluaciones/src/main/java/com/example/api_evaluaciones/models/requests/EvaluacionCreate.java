package com.example.api_evaluaciones.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EvaluacionCreate {
    
    
    private int id; 

    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    
    private Integer idUsuario;        

    
    private Integer idCurso; 
}
