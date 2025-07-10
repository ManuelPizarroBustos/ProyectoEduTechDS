package com.example.api_resenas.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResenaCreate {
    
    
    private int id; 

    
    private Integer idUsuario;
    
    
    private Integer idCurso;    

    
    private Integer calificacion;
    
    @NotBlank
    private String comentario;
}
