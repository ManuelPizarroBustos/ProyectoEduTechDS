package main.java.com.example.api_roles.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_roles.controllers.RolController;
import com.example.api_roles.models.entities.Rol;

@Component
public class RolModelAssembler implements RepresentationModelAssembler<Rol, EntityModel<Rol>> {

    
    @Override
    public EntityModel<Rol> toModel(Rol rol) {
        return EntityModel.of(rol,
            linkTo(methodOn(RolController.class).obtenerUno(rol.getId())).withSelfRel(),
            linkTo(methodOn(RolController.class).obtenerTodos()).withRel("roles")
        );
    }
}
