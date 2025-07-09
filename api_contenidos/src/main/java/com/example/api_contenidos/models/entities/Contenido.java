package main.java.com.example.api_contenidos.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "contenido")
public class Contenido {

    @Id
    private int id;

    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String urlRecurso;

    @Column(nullable = false)
    private Integer idCurso;
}
    