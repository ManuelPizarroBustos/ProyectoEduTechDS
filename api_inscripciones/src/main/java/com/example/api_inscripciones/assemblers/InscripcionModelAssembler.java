package com.example.api_inscripciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_inscripciones.controllers.InscripcionController;
import com.example.api_inscripciones.models.entities.Inscripcion;

@Component
public class InscripcionModelAssembler implements RepresentationModelAssembler<Inscripcion, EntityModel<Inscripcion>> {

    
    @Override
    public EntityModel<Inscripcion> toModel(Inscripcion inscripcion) {
        return EntityModel.of(inscripcion,
            linkTo(methodOn(InscripcionController.class).obtenerUno(inscripcion.getId())).withSelfRel(),
            linkTo(methodOn(InscripcionController.class).obtenerTodos()).withRel("inscripciones")
        );
    }   
}
