package main.java.com.example.api_contenidos.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_contenidos.controllers.ContenidoController;
import com.example.api_contenidos.models.entities.Contenido;

@Component
public class ContenidoModelAssembler implements RepresentationModelAssembler<Contenido, EntityModel<Contenido>> {

    
    @Override
    public EntityModel<Contenido> toModel(Contenido contenido) {
        return EntityModel.of(contenido,
            linkTo(methodOn(ContenidoController.class).obtenerUno(contenido.getId())).withSelfRel(),
            linkTo(methodOn(ContenidoController.class).obtenerTodos()).withRel("contenidos")
        );
    }
}
