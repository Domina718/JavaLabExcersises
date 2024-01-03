package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;

public interface ClientService {
    void addNew(ClientDTO clientDTO) throws Exception;

    Client findById(Long id) throws Exception;
}
