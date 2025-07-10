package com.example.api_instructores.models.requests;

import lombok.Data;

@Data
public class InstructorUpdate {
    private int id;
    private String nombre;
    private String especialidad;
    private String email;
}
