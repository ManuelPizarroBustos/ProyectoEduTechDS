package main.java.com.example.api_contenidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_contenidos.models.entities.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido,Integer> {
    
}
