package com.smartyatra.smart_yatra_backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookingRequest {
    private Long packageId;
    private LocalDate travelDate;
    private int numberOfPeople;
}