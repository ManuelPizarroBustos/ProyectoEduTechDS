package com.example.api_roles.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolCreate {
    
    
    private int id; 

    @NotBlank
    private String nombreRol;

    @NotBlank
    private String descripcion; 
}
