package com.example.api_proveedores.models.requests;

import lombok.Data;

@Data
public class ProveedorUpdate {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String servicio;
}
