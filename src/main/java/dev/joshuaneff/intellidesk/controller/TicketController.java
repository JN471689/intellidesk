package dev.joshuaneff.intellidesk.controller;

import dev.joshuaneff.intellidesk.model.Ticket;
import dev.joshuaneff.intellidesk.model.TicketStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")

public class TicketController {


    private final List<Ticket> tickets = new ArrayList<>();

    @GetMapping
    public List<Ticket> getTickets() {
        return tickets;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        ticket.setId((long) tickets.size() + 1);
        ticket.setStatus(TicketStatus.OPEN);

        tickets.add(ticket);

        return ticket;
    }
}

