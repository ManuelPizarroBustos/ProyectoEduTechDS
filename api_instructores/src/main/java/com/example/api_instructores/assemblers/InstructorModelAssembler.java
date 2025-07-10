package com.example.api_instructores.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_instructores.controllers.InstructorController;
import com.example.api_instructores.models.entities.Instructor;

@Component
public class InstructorModelAssembler implements RepresentationModelAssembler<Instructor, EntityModel<Instructor>> {

    
    @Override
    public EntityModel<Instructor> toModel(Instructor instructor) {
        return EntityModel.of(instructor,
            linkTo(methodOn(InstructorController.class).obtenerUno(instructor.getId())).withSelfRel(),
            linkTo(methodOn(InstructorController.class).obtenerTodos()).withRel("instructores")
        );
    }
}
