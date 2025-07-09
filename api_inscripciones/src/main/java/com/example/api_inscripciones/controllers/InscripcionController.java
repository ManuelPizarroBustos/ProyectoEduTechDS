package com.example.api_inscripciones.controllers;

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

import com.example.api_inscripciones.assemblers.InscripcionModelAssembler;
import com.example.api_inscripciones.models.entities.Inscripcion;
import com.example.api_inscripciones.models.requests.InscripcionCreate;
import com.example.api_inscripciones.models.requests.InscripcionUpdate;
import com.example.api_inscripciones.services.InscripcionService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    
    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private InscripcionModelAssembler assembler;

    @GetMapping("/")
    public CollectionModel<EntityModel<Inscripcion>> obtenerTodos() {
        List<EntityModel<Inscripcion>> inscripciones = inscripcionService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(inscripciones,
            linkTo(methodOn(InscripcionController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Inscripcion> obtenerUno(@PathVariable int id) {
        Inscripcion inscripcion = inscripcionService.obtenerPorId(id);
        return assembler.toModel(inscripcion);
    }

    @PostMapping("/")
    public EntityModel<Inscripcion> registrar(@Valid @RequestBody InscripcionCreate body) {
        Inscripcion inscripcion = inscripcionService.registrar(body);
        return assembler.toModel(inscripcion);
    }

    @PutMapping("/")
    public EntityModel<Inscripcion> actualizar(@Valid @RequestBody InscripcionUpdate body) {
        Inscripcion inscripcion = inscripcionService.actualizar(body);
        return assembler.toModel(inscripcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        inscripcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
