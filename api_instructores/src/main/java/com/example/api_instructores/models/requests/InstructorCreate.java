package com.example.api_instructores.models.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InstructorCreate {
    
    
    private int id; 

    @NotBlank
    private String nombre;
    
    @NotBlank
    private String especialidad;

    @NotBlank
    @Email
    private String email;

}