package com.example.api_contenidos.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContenidoCreate {
    
    @NotBlank
    private int id; 

    @NotBlank
    private String titulo;
    
    @NotBlank
    private String tipo;
    
    @NotBlank
    private String urlRecurso;        

    @NotBlank
    private Integer idCurso; 
}
