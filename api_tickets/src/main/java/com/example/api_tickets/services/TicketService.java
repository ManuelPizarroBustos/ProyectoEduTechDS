package com.example.api_tickets.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_tickets.models.entities.Ticket;
import com.example.api_tickets.models.requests.TicketCreate;
import com.example.api_tickets.models.requests.TicketUpdate;
import com.example.api_tickets.repositories.TicketRepository;


@Service
public class TicketService{
    
    @Autowired
    private TicketRepository ticketRepository;

    

    public List<Ticket> obtenerTodos(){
        return ticketRepository.findAll();
    }

    public Ticket obtenerPorId(int id){
        return ticketRepository.findById(id).orElse(null);
    }


    public Ticket registrar(TicketCreate ticket){
        try {
            Ticket nuevoTicket = new Ticket();
            nuevoTicket.setId(ticket.getId());
            nuevoTicket.setIdUsuario(ticket.getIdUsuario());
            nuevoTicket.setTitulo(ticket.getTitulo());
            nuevoTicket.setDescripcion(ticket.getDescripcion());
            nuevoTicket.setEstado(ticket.getEstado());
            nuevoTicket.setFechaCreacion(ticket.getFechaCreacion());// ejemplo: ADMIN, ESTUDIANTE, INSTRUCTOR, GERENTE

            return ticketRepository.save(nuevoTicket);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Ticket no registrado");
        }
    }

    public Ticket actualizar(TicketUpdate body) {
        Ticket ticket = ticketRepository.findById(body.getId()).orElse(null);
        if (ticket == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket no encontrado");
        }

        if(body.getIdUsuario() != null) {
            ticket.setIdUsuario(body.getIdUsuario());
        }

        if(body.getTitulo() != null) {
            ticket.setTitulo(body.getTitulo());
        }
        
        if(body.getDescripcion() != null) {
            ticket.setDescripcion(body.getDescripcion());
        }

        if(body.getEstado() != null) {
            ticket.setEstado(body.getEstado());
        }
        
        if(body.getFechaCreacion() != null) {
            ticket.setFechaCreacion(body.getFechaCreacion());
        }
    
        return ticketRepository.save(ticket);
    }

    public void eliminar(int id){
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket no encontrado");
        }
        ticketRepository.delete(ticket);
    
    }
    

    
}
