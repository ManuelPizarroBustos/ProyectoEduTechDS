package com.example.api_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_tickets.models.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    
}
