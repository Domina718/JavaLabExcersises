package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMeasuringRequest {
    private Long id;

    private Long clientId;

    private Long deviceId;

    private String data;

    private LocalDate date;
}
