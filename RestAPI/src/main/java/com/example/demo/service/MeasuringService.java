package com.example.demo.service;

import com.example.demo.dto.CreateMeasuringRequest;
import com.example.demo.dto.MeasuringDTO;
import com.example.demo.model.Measuring;

import java.util.List;

public interface MeasuringService {
    void addNew(CreateMeasuringRequest createMeasuringRequest) throws Exception;

    List<MeasuringDTO> getAll();
}
