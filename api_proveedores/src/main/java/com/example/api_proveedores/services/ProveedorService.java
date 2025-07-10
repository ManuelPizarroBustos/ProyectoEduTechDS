package com.example.api_proveedores.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_proveedores.models.entities.Proveedor;
import com.example.api_proveedores.models.requests.ProveedorCreate;
import com.example.api_proveedores.models.requests.ProveedorUpdate;
import com.example.api_proveedores.repositories.ProveedorRepository;


@Service
public class ProveedorService{
    
    @Autowired
    private ProveedorRepository proveeedorRepository;

    

    public List<Proveedor> obtenerTodos(){
        return proveeedorRepository.findAll();
    }

    public Proveedor obtenerPorId(int id){
        return proveeedorRepository.findById(id).orElse(null);
    }


    public Proveedor registrar(ProveedorCreate proveeedor){
        try {
            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setId(proveeedor.getId());
            nuevoProveedor.setNombre(proveeedor.getNombre());
            nuevoProveedor.setEmail(proveeedor.getEmail());
            nuevoProveedor.setTelefono(proveeedor.getTelefono());
            nuevoProveedor.setServicio(proveeedor.getServicio());

            return proveeedorRepository.save(nuevoProveedor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Proveedor no registrado");
        }
    }

    public Proveedor actualizar(ProveedorUpdate body) {
        Proveedor proveeedor = proveeedorRepository.findById(body.getId()).orElse(null);
        if (proveeedor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }

        if(body.getNombre() != null) {
            proveeedor.setNombre(body.getNombre());
        }

        if(body.getEmail() != null) {
            proveeedor.setEmail(body.getEmail());
        }
        
        if(body.getTelefono() != null) {
            proveeedor.setTelefono(body.getTelefono());
        }

        if(body.getServicio() != null) {
            proveeedor.setServicio(body.getServicio());
        }
        
        return proveeedorRepository.save(proveeedor);
    }

    public void eliminar(int id){
        Proveedor proveeedor = proveeedorRepository.findById(id).orElse(null);
        if (proveeedor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
        proveeedorRepository.delete(proveeedor);
    
    }
    

    
}
