package com.example.a10spring_boot_hibernate_library.controllers;

import com.example.a10spring_boot_hibernate_library.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.a10spring_boot_hibernate_library.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Client getSingleClient() {
        List<Client> clients = clientService.getAllClients();
        if (!clients.isEmpty()) {
            Client firstClient = clients.get(0);  // Get the first client
            System.out.println(firstClient.toString());
            return firstClient;
        } else {
            return null;  // or handle the case when there are no clients
        }
    }
}
