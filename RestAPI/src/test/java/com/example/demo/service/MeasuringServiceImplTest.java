package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.CreateMeasuringRequest;
import com.example.demo.dto.DeviceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeasuringServiceImplTest {

    @Autowired
    MeasuringService measuringService;

    @Autowired
    ClientService clientService;

    @Autowired
    DeviceService deviceService;

    @Test
    void addNew() throws Exception {
        clientService.addNew(new ClientDTO());
        deviceService.addNew(new DeviceDTO());

        CreateMeasuringRequest request = new CreateMeasuringRequest();

        request.setClientId(4L);
        request.setDeviceId(4L);

        Assertions.assertDoesNotThrow(() -> measuringService.addNew(request));
    }

    @Test
    void addNewThrowsException() throws Exception {
        clientService.addNew(new ClientDTO());
        deviceService.addNew(new DeviceDTO());

        CreateMeasuringRequest request = new CreateMeasuringRequest();

        request.setClientId(1L);
        request.setDeviceId(1L);

        Assertions.assertThrows(Exception.class, () -> measuringService.addNew(request));
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> measuringService.getAll());
    }
}