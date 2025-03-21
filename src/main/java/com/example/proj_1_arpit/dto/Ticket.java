package com.example.proj_1_arpit.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String ticketNumber;
    private String flightNumber;
    private String travelerName;
    private String contactEmail;
    private boolean isVoid;
    private String seatAssignment;
    private LocalDateTime bookingTime;
    private double pricePaid;
    private String travelDate;
    private boolean hasBaggage;
}