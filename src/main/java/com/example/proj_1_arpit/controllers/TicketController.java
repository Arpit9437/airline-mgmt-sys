package com.example.proj_1_arpit.controllers;
import com.example.proj_1_arpit.dto.Ticket;
import com.example.proj_1_arpit.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (ticket.getFlightNumber() == null || ticket.getTravelerName() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticket.setBookingTime(LocalDateTime.now());

        Ticket createdTicket = ticketService.registerBooking(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id) {
        Ticket ticket = ticketService.findReservationByNumber(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelTicket(@PathVariable String id) {
        boolean cancelled = ticketService.voidReservation(id);
        if (cancelled) {
            return new ResponseEntity<>("Ticket cancelled successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
        }
    }
}