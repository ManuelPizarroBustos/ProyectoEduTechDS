package main.java.com.example.api_instructores.controllers;

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

import com.example.api_instructores.assemblers.InstructorModelAssembler;
import com.example.api_instructores.models.entities.Instructor;
import com.example.api_instructores.models.requests.InstructorCreate;
import com.example.api_instructores.models.requests.InstructorUpdate;
import com.example.api_instructores.services.InstructorService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/instructor")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Instructor>> obtenerTodos() {
        List<EntityModel<Instructor>> instructores = instructorService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(instructores,
            linkTo(methodOn(InstructorController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Instructor> obtenerUno(@PathVariable int id) {
        Instructor instructor = instructorService.obtenerPorId(id);
        return assembler.toModel(instructor);
    }

    @PostMapping("/")
    public EntityModel<Instructor> registrar(@Valid @RequestBody InstructorCreate body) {
        Instructor instructor = instructorService.registrar(body);
        return assembler.toModel(instructor);
    }

    @PutMapping("/")
    public EntityModel<Instructor> actualizar(@Valid @RequestBody InstructorUpdate body) {
        Instructor instructor = instructorService.actualizar(body);
        return assembler.toModel(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        instructorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
