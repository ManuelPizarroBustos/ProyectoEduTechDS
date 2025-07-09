package com.example.api_inscripciones.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InscripcionCreate {
    
    @NotBlank
    private int id;

    @NotBlank
    private Integer usuarioId;
    
    @NotBlank
    private Integer cursoId;

    @NotBlank
    private String estado;

    @NotBlank
    private String fechaInscripcion;
}
