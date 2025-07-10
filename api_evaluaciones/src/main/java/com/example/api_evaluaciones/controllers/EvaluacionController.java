package com.example.api_evaluaciones.controllers;

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

import com.example.api_evaluaciones.assemblers.EvaluacionModelAssembler;
import com.example.api_evaluaciones.models.entities.Evaluacion;
import com.example.api_evaluaciones.models.requests.EvaluacionCreate;
import com.example.api_evaluaciones.models.requests.EvaluacionUpdate;
import com.example.api_evaluaciones.services.EvaluacionService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {
    
    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private EvaluacionModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Evaluacion>> obtenerTodos() {
        List<EntityModel<Evaluacion>> evaluaciones = evaluacionService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(evaluaciones,
            linkTo(methodOn(EvaluacionController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Evaluacion> obtenerUno(@PathVariable int id) {
        Evaluacion evaluacion = evaluacionService.obtenerPorId(id);
        return assembler.toModel(evaluacion);
    }

    @PostMapping("/")
    public EntityModel<Evaluacion> registrar(@Valid @RequestBody EvaluacionCreate body) {
        Evaluacion evaluacion = evaluacionService.registrar(body);
        return assembler.toModel(evaluacion);
    }

    @PutMapping("/")
    public EntityModel<Evaluacion> actualizar(@Valid @RequestBody EvaluacionUpdate body) {
        Evaluacion evaluacion = evaluacionService.actualizar(body);
        return assembler.toModel(evaluacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        evaluacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
