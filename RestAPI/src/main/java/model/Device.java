package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String data;
}
