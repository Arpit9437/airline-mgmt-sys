package com.example.proj_1_arpit.controllers;
import com.example.proj_1_arpit.dto.Flight;
import com.example.proj_1_arpit.services.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights(@RequestParam(required = false) String sort) {
        List<Flight> flights = flightService.getAvailableFlights();
        if ("asc".equals(sort)) {
            flights.sort(Comparator.comparing(Flight::getFlightNumber));
        }

        return flights;
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable String id) {
        return flightService.findFlightByNumber(id);
    }

    @GetMapping("/{id}/schedules")
    public List<String> getFlightSchedules(
            @PathVariable String id,
            @RequestParam(required = false) String dates) {
        List<String> schedules = flightService.getAvailableDatesForFlight(id);
        // Filter by dates if parameter is provided
        if (dates != null && schedules != null) {
            schedules = schedules.stream()
                    .filter(date -> date.contains(dates))
                    .toList();
        }
        return schedules;
    }
}