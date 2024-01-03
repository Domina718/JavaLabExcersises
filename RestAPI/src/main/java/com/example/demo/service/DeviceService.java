package com.example.demo.service;

import com.example.demo.dto.DeviceDTO;
import com.example.demo.model.Device;

public interface DeviceService {

    void addNew(DeviceDTO deviceDTO) throws Exception;

    Device findById(Long id) throws Exception;

}
