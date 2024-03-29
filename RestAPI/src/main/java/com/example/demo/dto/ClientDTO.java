package com.example.demo.dto;

import com.example.demo.model.Measuring;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;

    private String address;

    private Set<Measuring> measuring;
}
