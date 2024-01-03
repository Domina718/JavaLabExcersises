package com.example.demo.dto;

import com.example.demo.model.Client;
import com.example.demo.model.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasuringDTO {
    private Long id;

    private Client client;

    private Device device;

    private String data;

    private LocalDate date;
}
