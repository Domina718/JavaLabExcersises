package com.example.demo.model;

import com.example.demo.repository.DeviceRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String address;

    @OneToMany(mappedBy = "client")
    private Set<Measuring> measuring;
}
