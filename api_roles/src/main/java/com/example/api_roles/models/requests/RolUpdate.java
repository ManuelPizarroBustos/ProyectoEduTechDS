package com.example.api_roles.models.requests;

import lombok.Data;

@Data
public class RolUpdate {
    private int id;
    private String nombreRol;
    private String descripcion;
}
