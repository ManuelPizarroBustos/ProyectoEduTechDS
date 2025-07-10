package com.example.api_instructores.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_instructores.models.entities.Instructor;
import com.example.api_instructores.models.requests.InstructorCreate;
import com.example.api_instructores.models.requests.InstructorUpdate;
import com.example.api_instructores.repositories.InstructorRepository;


@Service
public class InstructorService{
    
    @Autowired
    private InstructorRepository instructorRepository;

    

    public List<Instructor> obtenerTodos(){
        return instructorRepository.findAll();
    }

    public Instructor obtenerPorId(int id){
        return instructorRepository.findById(id).orElse(null);
    }


    public Instructor registrar(InstructorCreate instructor){
        try {
            Instructor nuevoInstructor = new Instructor();
            nuevoInstructor.setId(instructor.getId());
            nuevoInstructor.setNombre(instructor.getNombre());
            nuevoInstructor.setEspecialidad(instructor.getEspecialidad());
            nuevoInstructor.setEmail(instructor.getEmail());

            return instructorRepository.save(nuevoInstructor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Instructor no registrado");
        }
    }

    public Instructor actualizar(InstructorUpdate body) {
        Instructor instructor = instructorRepository.findById(body.getId()).orElse(null);
        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
        }

        if(body.getNombre() != null) {
            instructor.setNombre(body.getNombre());
        }

        if(body.getEspecialidad() != null) {
            instructor.setEspecialidad(body.getEspecialidad());
        }

        if(body.getEmail() != null) {
            instructor.setEmail(body.getEmail());
        }
        
    
        return instructorRepository.save(instructor);
    }

    public void eliminar(int id){
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
        }
        instructorRepository.delete(instructor);
    
    }
    

    
}
