package com.smartyatra.smart_yatra_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationSearchResponse {
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String thumbnailurl;
}