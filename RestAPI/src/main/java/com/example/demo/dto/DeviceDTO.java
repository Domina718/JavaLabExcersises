package com.example.demo.dto;

import com.example.demo.model.Measuring;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private Long id;

    private Set<Measuring> measuring;
}