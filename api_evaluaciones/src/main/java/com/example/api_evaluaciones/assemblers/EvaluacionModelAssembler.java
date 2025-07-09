package main.java.com.example.api_evaluaciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_evaluaciones.controllers.EvaluacionController;
import com.example.api_evaluaciones.models.entities.Evaluacion;

@Component
public class EvaluacionModelAssembler implements RepresentationModelAssembler<Evaluacion, EntityModel<Evaluacion>> {

    
    @Override
    public EntityModel<Evaluacion> toModel(Evaluacion evaluacion) {
        return EntityModel.of(evaluacion,
            linkTo(methodOn(EvaluacionController.class).obtenerUno(evaluacion.getId())).withSelfRel(),
            linkTo(methodOn(EvaluacionController.class).obtenerTodos()).withRel("evaluaciones")
        );
    }
}
