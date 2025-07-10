package com.example.api_inscripciones.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InscripcionCreate {
    
    
    private int id;

    
    private Integer usuarioId;
    
    
    private Integer cursoId;

    @NotBlank
    private String estado;

    @NotBlank
    private String fechaInscripcion;
}
