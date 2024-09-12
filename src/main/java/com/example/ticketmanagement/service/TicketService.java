package com.example.ticketmanagement.service;

import com.example.ticketmanagement.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TicketService {
    private final List<Ticket> tickets = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Optional<Ticket> getTicketById(Long id) {
        return tickets.stream().filter(ticket -> ticket.getId().equals(id)).findFirst();
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setId(counter.incrementAndGet());
        tickets.add(ticket);
        return ticket;
    }

    public Optional<Ticket> updateTicket(Long id, Ticket updatedTicket) {
        return getTicketById(id).map(ticket -> {
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
            return ticket;
        });
    }

    public boolean deleteTicket(Long id) {
        return tickets.removeIf(ticket -> ticket.getId().equals(id));
    }
}
