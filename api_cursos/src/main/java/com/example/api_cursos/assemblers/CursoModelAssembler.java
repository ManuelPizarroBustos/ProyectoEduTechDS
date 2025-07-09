package com.example.api_cursos.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_cursos.controllers.CursoController;
import com.example.api_cursos.models.entities.Curso;

@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso, EntityModel<Curso>> {

    
    @Override
    public EntityModel<Curso> toModel(Curso curso) {
        return EntityModel.of(curso,
            linkTo(methodOn(CursoController.class).obtenerUno(curso.getId())).withSelfRel(),
            linkTo(methodOn(CursoController.class).obtenerTodos()).withRel("cursos")
        );
    }   
}
