package com.example.api_resenas.controllers;

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

import com.example.api_resenas.assemblers.ResenaModelAssembler;
import com.example.api_resenas.models.entities.Resena;
import com.example.api_resenas.models.requests.ResenaCreate;
import com.example.api_resenas.models.requests.ResenaUpdate;
import com.example.api_resenas.services.ResenaService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/resena")
public class ResenaController {
    
    @Autowired
    private ResenaService resenaService;

    @Autowired
    private ResenaModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Resena>> obtenerTodos() {
        List<EntityModel<Resena>> resenas = resenaService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(resenas,
            linkTo(methodOn(ResenaController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Resena> obtenerUno(@PathVariable int id) {
        Resena resena = resenaService.obtenerPorId(id);
        return assembler.toModel(resena);
    }

    @PostMapping("/")
    public EntityModel<Resena> registrar(@Valid @RequestBody ResenaCreate body) {
        Resena resena = resenaService.registrar(body);
        return assembler.toModel(resena);
    }

    @PutMapping("/")
    public EntityModel<Resena> actualizar(@Valid @RequestBody ResenaUpdate body) {
        Resena resena = resenaService.actualizar(body);
        return assembler.toModel(resena);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        resenaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

