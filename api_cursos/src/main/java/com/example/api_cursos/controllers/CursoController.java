package com.example.api_cursos.controllers;

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

import com.example.api_cursos.assemblers.CursoModelAssembler;
import com.example.api_cursos.models.entities.Curso;
import com.example.api_cursos.models.requests.CursoCreate;
import com.example.api_cursos.models.requests.CursoUpdate;
import com.example.api_cursos.services.CursoService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoModelAssembler assembler;

    @GetMapping("/")
    public CollectionModel<EntityModel<Curso>> obtenerTodos() {
        List<EntityModel<Curso>> cursos = cursoService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(cursos,
            linkTo(methodOn(CursoController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Curso> obtenerUno(@PathVariable int id) {
        Curso curso = cursoService.obtenerPorId(id);
        return assembler.toModel(curso);
    }

    @PostMapping("/")
    public EntityModel<Curso> registrar(@Valid @RequestBody CursoCreate body) {
        Curso curso = cursoService.registrar(body);
        return assembler.toModel(curso);
    }

    @PutMapping("/")
    public EntityModel<Curso> actualizar(@Valid @RequestBody CursoUpdate body) {
        Curso curso = cursoService.actualizar(body);
        return assembler.toModel(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
