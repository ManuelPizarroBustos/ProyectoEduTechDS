package main.java.com.example.api_roles.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    private int id;

    @Column(nullable = false)
    private String nombreRol;// ejemplo: ADMIN, ESTUDIANTE, INSTRUCTOR, GERENTE

    @Column(nullable = false)
    private String descripcion;// Descripción del rol, por ejemplo: "Administrador del sistema", "
}
    