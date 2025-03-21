package com.example.proj_1_arpit.services;
import com.example.proj_1_arpit.dto.Flight;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

@Service
public class FlightService {
    private final List<Flight> flightInventory = new ArrayList<>();
    public FlightService() {
        flightInventory.add(new Flight("XYZ987", "Kingfisher", "Cannes", "Goa", "03:00 AM", "12:00 AM",
                List.of("2022-03-23", "2022-03-24"), 536, Duration.ofHours(8), 3000.0, true));
        flightInventory.add(new Flight("AI5678", "Indian Air", "Darjeeling", "Guwahati", "05:00 PM", "09:00 PM",
                List.of("2024-03-1", "2024-03-30"), 106, Duration.ofHours(1), 867.6, false));
    }

    public List<Flight> getAvailableFlights() {
        return flightInventory;
    }

    public Flight findFlightByNumber(String flightNumber) {
        return flightInventory.stream().filter(f -> f.getFlightNumber().equals(flightNumber)).findFirst().orElse(null);
    }

    public List<String> getAvailableDatesForFlight(String flightNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        return (flight != null) ? flight.getAvailableDates() : null;
    }
}