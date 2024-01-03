package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.repository.ClientRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceImplTest {


    @Autowired
    ClientService clientService;

    @Test
    void addNew() throws Exception {
        Assertions.assertDoesNotThrow(() -> clientService.addNew(new ClientDTO()));
    }

    @Test
    void addNewThrowsException() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setAddress("address");

        clientService.addNew(clientDTO);
        Assertions.assertThrows(Exception.class, () -> clientService.addNew(clientDTO));
    }

    @Test
    void findById() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientService.addNew(clientDTO);
        Assertions.assertDoesNotThrow(() -> clientService.findById(1L));
    }

    @Test
    void findByIdThrowsException() throws Exception {
        Assertions.assertThrows(Exception.class, () -> clientService.findById(10000L));
    }
}