package com.example.api_resenas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_resenas.controllers.ResenaController;
import com.example.api_resenas.models.entities.Resena;

@Component
public class ResenaModelAssembler implements RepresentationModelAssembler<Resena, EntityModel<Resena>> {

    
    @Override
    public EntityModel<Resena> toModel(Resena resena) {
        return EntityModel.of(resena,
            linkTo(methodOn(ResenaController.class).obtenerUno(resena.getId())).withSelfRel(),
            linkTo(methodOn(ResenaController.class).obtenerTodos()).withRel("resenas")
        );
    }
}
