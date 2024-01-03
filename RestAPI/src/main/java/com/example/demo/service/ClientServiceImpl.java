package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public void addNew(ClientDTO clientDTO) throws Exception {
        Client client = Mapper.clientDTOToClient(clientDTO);
        try {
            clientRepository.save(client);
        } catch (Exception e) {
            throw new Exception("Address is already used");
        }

    }

    @Override
    public Client findById(Long id) throws Exception {

        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isEmpty()) {
            throw new Exception("Client with id " + id + " does not exist");
        }

        return optionalClient.get();

    }

}
