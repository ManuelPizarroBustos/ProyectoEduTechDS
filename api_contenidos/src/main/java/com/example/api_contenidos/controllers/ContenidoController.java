package com.example.api_contenidos.controllers;

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

import com.example.api_contenidos.assemblers.ContenidoModelAssembler;
import com.example.api_contenidos.models.entities.Contenido;
import com.example.api_contenidos.models.requests.ContenidoCreate;
import com.example.api_contenidos.models.requests.ContenidoUpdate;
import com.example.api_contenidos.services.ContenidoService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    
    @Autowired
    private ContenidoService contenidoService;

    @Autowired
    private ContenidoModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Contenido>> obtenerTodos() {
        List<EntityModel<Contenido>> contenidos = contenidoService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Contenido> obtenerUno(@PathVariable int id) {
        Contenido contenido = contenidoService.obtenerPorId(id);
        return assembler.toModel(contenido);
    }

    @PostMapping("/")
    public EntityModel<Contenido> registrar(@Valid @RequestBody ContenidoCreate body) {
        Contenido contenido = contenidoService.registrar(body);
        return assembler.toModel(contenido);
    }

    @PutMapping("/")
    public EntityModel<Contenido> actualizar(@Valid @RequestBody ContenidoUpdate body) {
        Contenido contenido = contenidoService.actualizar(body);
        return assembler.toModel(contenido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        contenidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
