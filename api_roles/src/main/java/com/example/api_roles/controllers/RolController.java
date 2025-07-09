package main.java.com.example.api_roles.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_roles.assemblers.RolModelAssembler;
import com.example.api_roles.models.entities.Rol;
import com.example.api_roles.models.requests.RolCreate;
import com.example.api_roles.models.requests.RolUpdate;
import com.example.api_roles.services.RolService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private RolService rolService;

    @Autowired
    private RolModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Rol>> obtenerTodos() {
        List<EntityModel<Rol>> roles = rolService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(roles,
            linkTo(methodOn(RolController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Rol> obtenerUno(@PathVariable int id) {
        Rol rol = rolService.obtenerPorId(id);
        return assembler.toModel(rol);
    }

    @PostMapping("/")
    public EntityModel<Rol> registrar(@Valid @RequestBody RolCreate body) {
        Rol rol = rolService.registrar(body);
        return assembler.toModel(rol);
    }

    @PutMapping("/")
    public EntityModel<Rol> actualizar(@Valid @RequestBody RolUpdate body) {
        Rol rol = rolService.actualizar(body);
        return assembler.toModel(rol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
