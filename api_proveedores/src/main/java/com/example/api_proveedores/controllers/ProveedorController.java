package com.example.api_proveedores.controllers;

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

import com.example.api_proveedores.assemblers.ProveedorModelAssembler;
import com.example.api_proveedores.models.entities.Proveedor;
import com.example.api_proveedores.models.requests.ProveedorCreate;
import com.example.api_proveedores.models.requests.ProveedorUpdate;
import com.example.api_proveedores.services.ProveedorService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProveedorModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Proveedor>> obtenerTodos() {
        List<EntityModel<Proveedor>> proveedores = proveedorService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(proveedores,
            linkTo(methodOn(ProveedorController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Proveedor> obtenerUno(@PathVariable int id) {
        Proveedor proveedor = proveedorService.obtenerPorId(id);
        return assembler.toModel(proveedor);
    }

    @PostMapping("/")
    public EntityModel<Proveedor> registrar(@Valid @RequestBody ProveedorCreate body) {
        Proveedor proveedor = proveedorService.registrar(body);
        return assembler.toModel(proveedor);
    }

    @PutMapping("/")
    public EntityModel<Proveedor> actualizar(@Valid @RequestBody ProveedorUpdate body) {
        Proveedor proveedor = proveedorService.actualizar(body);
        return assembler.toModel(proveedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        proveedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
