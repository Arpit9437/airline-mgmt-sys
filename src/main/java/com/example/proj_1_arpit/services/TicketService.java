package com.example.proj_1_arpit.services;
import com.example.proj_1_arpit.dto.Ticket;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class TicketService {
    private final List<Ticket> bookingRecords = new ArrayList<>();

    public List<Ticket> getAllReservations() {
        return bookingRecords;
    }

    public Ticket findReservationByNumber(String ticketNumber) {
        return bookingRecords.stream().filter(t -> t.getTicketNumber().equals(ticketNumber)).findFirst().orElse(null);
    }

    public Ticket registerBooking(Ticket ticket) {
        bookingRecords.add(ticket);
        return ticket;
    }

    public boolean voidReservation(String ticketNumber) {
        Optional<Ticket> reservation = bookingRecords.stream().filter(t -> t.getTicketNumber().equals(ticketNumber)).findFirst();
        reservation.ifPresent(t -> t.setVoid(true));
        return reservation.isPresent();
    }

    public List<Ticket> getReservationsByEmail(String contactEmail) {
        return bookingRecords.stream()
                .filter(t -> t.getContactEmail().equals(contactEmail))
                .collect(Collectors.toList());
    }
}