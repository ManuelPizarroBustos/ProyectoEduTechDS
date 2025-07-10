package com.example.api_roles.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_roles.models.entities.Rol;
import com.example.api_roles.models.requests.RolCreate;
import com.example.api_roles.models.requests.RolUpdate;
import com.example.api_roles.repositories.RolRepository;


@Service
public class RolService{
    
    @Autowired
    private RolRepository rolRepository;

    

    public List<Rol> obtenerTodos(){
        return rolRepository.findAll();
    }

    public Rol obtenerPorId(int id){
        return rolRepository.findById(id).orElse(null);
    }


    public Rol registrar(RolCreate rol){
        try {
            Rol nuevoRol = new Rol();
            nuevoRol.setId(rol.getId());
            nuevoRol.setNombreRol(rol.getNombreRol());
            nuevoRol.setDescripcion(rol.getDescripcion());

            return rolRepository.save(nuevoRol);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Rol no registrado");
        }
    }

    public Rol actualizar(RolUpdate body) {
        Rol rol = rolRepository.findById(body.getId()).orElse(null);
        if (rol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        }

        if(body.getNombreRol() != null) {
            rol.setNombreRol(body.getNombreRol());
        }

        if(body.getDescripcion() != null) {
            rol.setDescripcion(body.getDescripcion());
        }
        
    
        return rolRepository.save(rol);
    }

    public void eliminar(int id){
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        }
        rolRepository.delete(rol);
    
    }
    

    
}
