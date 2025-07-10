package com.example.api_tickets.controllers;

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

import com.example.api_tickets.assemblers.TicketModelAssembler;
import com.example.api_tickets.models.entities.Ticket;
import com.example.api_tickets.models.requests.TicketCreate;
import com.example.api_tickets.models.requests.TicketUpdate;
import com.example.api_tickets.services.TicketService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Ticket>> obtenerTodos() {
        List<EntityModel<Ticket>> tickets = ticketService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(tickets,
            linkTo(methodOn(TicketController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Ticket> obtenerUno(@PathVariable int id) {
        Ticket ticket = ticketService.obtenerPorId(id);
        return assembler.toModel(ticket);
    }

    @PostMapping("/")
    public EntityModel<Ticket> registrar(@Valid @RequestBody TicketCreate body) {
        Ticket ticket = ticketService.registrar(body);
        return assembler.toModel(ticket);
    }

    @PutMapping("/")
    public EntityModel<Ticket> actualizar(@Valid @RequestBody TicketUpdate body) {
        Ticket ticket = ticketService.actualizar(body);
        return assembler.toModel(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        ticketService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
