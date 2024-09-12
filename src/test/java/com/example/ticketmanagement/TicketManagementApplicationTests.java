package com.example.ticketmanagement;

import com.example.ticketmanagement.model.Ticket;
import com.example.ticketmanagement.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TicketManagementApplicationTests {

    @Autowired
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        ticketService.getAllTickets().clear();
    }

    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }

    @Test
    public void testCreateTicket() {
        Ticket ticket = new Ticket("Ticket 1", "Open");
        Ticket createdTicket = ticketService.createTicket(ticket);

        assertNotNull(createdTicket);
        assertEquals("Ticket 1", createdTicket.getDescription());
        assertEquals("Open", createdTicket.getStatus());
    }

    @Test
    public void testGetTicketById() {
        Ticket ticket = new Ticket("Ticket 1", "Open");
        ticketService.createTicket(ticket);

        Optional<Ticket> foundTicket = ticketService.getTicketById(ticket.getId());

        assertTrue(foundTicket.isPresent());
        assertEquals("Ticket 1", foundTicket.get().getDescription());
        assertEquals("Open", foundTicket.get().getStatus());
    }

    @Test
    public void testUpdateTicket() {
        Ticket ticket = new Ticket("Ticket 1", "Open");
        ticketService.createTicket(ticket);

        Ticket updatedTicket = new Ticket("Updated Ticket 1", "Closed");
        Optional<Ticket> result = ticketService.updateTicket(ticket.getId(), updatedTicket);

        assertTrue(result.isPresent());
        assertEquals("Updated Ticket 1", result.get().getDescription());
        assertEquals("Closed", result.get().getStatus());
    }

    @Test
    public void testDeleteTicket() {
        Ticket ticket = new Ticket("Ticket 1", "Open");
        ticketService.createTicket(ticket);

        boolean isDeleted = ticketService.deleteTicket(ticket.getId());

        assertTrue(isDeleted);
        assertFalse(ticketService.getTicketById(ticket.getId()).isPresent());
    }

    @Test
    public void testGetAllTickets() {
        Ticket ticket1 = new Ticket("Ticket 1", "Open");
        Ticket ticket2 = new Ticket("Ticket 2", "Closed");
        ticketService.createTicket(ticket1);
        ticketService.createTicket(ticket2);

        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(2, tickets.size());
        assertTrue(tickets.contains(ticket1));
        assertTrue(tickets.contains(ticket2));
    }
}