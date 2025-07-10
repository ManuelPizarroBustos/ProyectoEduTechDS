package com.example.api_evaluaciones.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_evaluaciones.models.entities.Evaluacion;
import com.example.api_evaluaciones.models.requests.EvaluacionCreate;
import com.example.api_evaluaciones.models.requests.EvaluacionUpdate;
import com.example.api_evaluaciones.repositories.EvaluacionRepository;


@Service
public class EvaluacionService{
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    

    public List<Evaluacion> obtenerTodos(){
        return evaluacionRepository.findAll();
    }

    public Evaluacion obtenerPorId(int id){
        return evaluacionRepository.findById(id).orElse(null);
    }


    public Evaluacion registrar(EvaluacionCreate evaluacion){
        try {
            Evaluacion nuevoEvaluacion = new Evaluacion();
            nuevoEvaluacion.setId(evaluacion.getId());
            nuevoEvaluacion.setTitulo(evaluacion.getTitulo());
            nuevoEvaluacion.setDescripcion(evaluacion.getDescripcion());
            nuevoEvaluacion.setIdUsuario(evaluacion.getIdUsuario());
            nuevoEvaluacion.setIdCurso(evaluacion.getIdCurso());

            return evaluacionRepository.save(nuevoEvaluacion);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Evaluacion no registrado");
        }
    }

    public Evaluacion actualizar(EvaluacionUpdate body) {
        Evaluacion evaluacion = evaluacionRepository.findById(body.getId()).orElse(null);
        if (evaluacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrado");
        }

        if(body.getTitulo() != null) {
            evaluacion.setTitulo(body.getTitulo());
        }

        if(body.getDescripcion() != null) {
            evaluacion.setDescripcion(body.getDescripcion());
        }

        if(body.getIdUsuario() != null) {
            evaluacion.setIdUsuario(body.getIdUsuario());
        }
        
        if(body.getIdCurso() != null) {
            evaluacion.setIdCurso(body.getIdCurso());
        }
    
        return evaluacionRepository.save(evaluacion);
    }

    public void eliminar(int id){
        Evaluacion evaluacion = evaluacionRepository.findById(id).orElse(null);
        if (evaluacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrado");
        }
        evaluacionRepository.delete(evaluacion);
    
    }
    

    
}
