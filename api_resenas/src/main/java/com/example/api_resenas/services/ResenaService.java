package com.example.api_resenas.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_resenas.models.entities.Resena;
import com.example.api_resenas.models.requests.ResenaCreate;
import com.example.api_resenas.models.requests.ResenaUpdate;
import com.example.api_resenas.repositories.ResenaRepository;


@Service
public class ResenaService{
    
    @Autowired
    private ResenaRepository resenaRepository;

    

    public List<Resena> obtenerTodos(){
        return resenaRepository.findAll();
    }

    public Resena obtenerPorId(int id){
        return resenaRepository.findById(id).orElse(null);
    }


    public Resena registrar(ResenaCreate resena){
        try {
            Resena nuevoResena = new Resena();
            nuevoResena.setId(resena.getId());
            nuevoResena.setIdUsuario(resena.getIdUsuario());
            nuevoResena.setIdCurso(resena.getIdCurso());
            nuevoResena.setCalificacion(resena.getCalificacion());
            nuevoResena.setComentario(resena.getComentario());

            return resenaRepository.save(nuevoResena);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Resena no registrado");
        }
    }

    public Resena actualizar(ResenaUpdate body) {
        Resena resena = resenaRepository.findById(body.getId()).orElse(null);
        if (resena == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resena no encontrado");
        }

        if(body.getIdUsuario() != null) {
            resena.setIdUsuario(body.getIdUsuario());
        }

        if(body.getIdCurso() != null) {
            resena.setIdCurso(body.getIdCurso());
        }
        
        if(body.getCalificacion() != null) {
            resena.setCalificacion(body.getCalificacion());
        }

        if(body.getComentario() != null) {
            resena.setComentario(body.getComentario());
        }
        
    
        return resenaRepository.save(resena);
    }

    public void eliminar(int id){
        Resena resena = resenaRepository.findById(id).orElse(null);
        if (resena == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resena no encontrado");
        }
        resenaRepository.delete(resena);
    
    }
    

    
}
