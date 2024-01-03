package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.DeviceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeviceServiceImplTest {

    @Autowired
    DeviceService deviceService;

    @Test
    void addNew() throws Exception {
        Assertions.assertDoesNotThrow(() -> deviceService.addNew(new DeviceDTO()));
    }

    @Test
    void findById() throws Exception {
        Assertions.assertDoesNotThrow(() -> deviceService.findById(1L));
    }

    @Test
    void findByIdThrowsException() throws Exception {
        Assertions.assertThrows(Exception.class, () -> deviceService.findById(10000L));
    }
}