package com.example.uberapi.services;

import com.example.uberapi.entities.Client;
import com.example.uberapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {
    ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        if(clientRepository.findById(id).isPresent())
            return clientRepository.findById(id).get();
        return null;
    }
    public void insertClient(Client client) {
        clientRepository.save(client);
    }
}
