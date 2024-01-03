package com.example.demo.repository;

import com.example.demo.model.Measuring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasuringRepository extends JpaRepository <Measuring, Long> {

    List<Measuring> findByClientId (Long clientId);
}
