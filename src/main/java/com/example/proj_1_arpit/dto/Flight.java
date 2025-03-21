package com.example.proj_1_arpit.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private String flightNumber;
    private String carrierName;
    private String originCity;
    private String destinationCity;
    private String takeoffTime;
    private String landingTime;
    private List<String> availableDates;
    private int totalSeats;
    private Duration flightDuration;
    private double basePrice;
    private boolean isInternational;
}