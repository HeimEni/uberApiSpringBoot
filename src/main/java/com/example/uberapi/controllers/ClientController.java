package com.example.uberapi.controllers;

import com.example.uberapi.entities.Client;
import com.example.uberapi.entities.DTO.TaxiDTO;
import com.example.uberapi.entities.Taxi;
import com.example.uberapi.repositories.ClientRepository;
import com.example.uberapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:8081")

public class ClientController {
    private final ClientService clientService;
    private ClientService clientRepository;
    @Autowired
    public ClientController(ClientService clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<Client> index() {
        return clientRepository.getAllClients();
    }
    @PostMapping("/new")
    public ResponseEntity<Client> newClient(@RequestBody String phoneNumber) {
        try {
            Client client = new Client();
            client.setPhoneNumber(phoneNumber);
            clientService.insertClient(client);
            System.out.println(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
