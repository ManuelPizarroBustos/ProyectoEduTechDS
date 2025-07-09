package main.java.com.example.api_contenidos.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_contenidos.models.entities.Contenido;
import com.example.api_contenidos.models.requests.ContenidoCreate;
import com.example.api_contenidos.models.requests.ContenidoUpdate;
import com.example.api_contenidos.repositories.ContenidoRepository;


@Service
public class ContenidoService{
    
    @Autowired
    private ContenidoRepository contenidoRepository;

    

    public List<Contenido> obtenerTodos(){
        return contenidoRepository.findAll();
    }

    public Contenido obtenerPorId(int id){
        return contenidoRepository.findById(id).orElse(null);
    }


    public Contenido registrar(ContenidoCreate usuario){
        try {
            Contenido nuevoContenido = new Contenido();
            nuevoContenido.setId(contenido.getId());
            nuevoContenido.setNombre(contenido.getNombre());
            nuevoContenido.setTelefono(contenido.getTelefono());
            nuevoContenido.setPassword(contenido.getPassword());
            nuevoContenido.setIdRol(contenido.getIdRol());

            return contenidoRepository.save(nuevoContenido);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Contenido no registrado");
        }
    }

    public Contenido actualizar(ContenidoUpdate body) {
        Contenido contenido = contenidoRepository.findById(body.getId()).orElse(null);
        if (contenido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contenido no encontrado");
        }

        if(body.getNombre() != null) {
            contenido.setNombre(body.getNombre());
        }

        if(body.getTelefono() != null) {
            contenido.setTelefono(body.getTelefono());
        }

        if(body.getPassword() != null) {
            contenido.setPassword(body.getPassword());
        }
        
        if(body.getIdRol() != null) {
            contenido.setIdRol(body.getIdRol());
        }
    
        return contenidoRepository.save(contenido);
    }

    public void eliminar(int id){
        Contenido contenido = contenidoRepository.findById(id).orElse(null);
        if (contenido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contenido no encontrado");
        }
        contenidoRepository.delete(contenido);
    
    }
    

    
}
