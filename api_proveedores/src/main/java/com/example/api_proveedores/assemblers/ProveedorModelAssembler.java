package com.example.api_proveedores.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_proveedores.controllers.ProveedorController;
import com.example.api_proveedores.models.entities.Proveedor;

@Component
public class ProveedorModelAssembler implements RepresentationModelAssembler<Proveedor, EntityModel<Proveedor>> {

    
    @Override
    public EntityModel<Proveedor> toModel(Proveedor proveedor) {
        return EntityModel.of(proveedor,
            linkTo(methodOn(ProveedorController.class).obtenerUno(proveedor.getId())).withSelfRel(),
            linkTo(methodOn(ProveedorController.class).obtenerTodos()).withRel("proveedores")
        );
    }
}

