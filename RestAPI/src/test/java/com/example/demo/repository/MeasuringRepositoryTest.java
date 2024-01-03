package com.example.demo.repository;

import com.example.demo.model.Measuring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeasuringRepositoryTest {

    @Autowired
    MeasuringRepository measuringRepository;


    @Test
    void findByClientId() {
        List<Measuring> measurings = measuringRepository.findByClientId(1L);
        assertFalse(measurings.isEmpty());
    }
    @Test
    void findByClientIdNoResults() {
        List<Measuring> measurings = measuringRepository.findByClientId(100L);
        assertTrue(measurings.isEmpty());
    }
}