package com.example.api_resenas.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResenaCreate {
    
    @NotBlank
    private int id; 

    @NotBlank
    private Integer idUsuario;
    
    @NotBlank
    private Integer idCurso;    

    @NotBlank
    private Integer calificacion;
    
    @NotBlank
    private String comentario;
}
