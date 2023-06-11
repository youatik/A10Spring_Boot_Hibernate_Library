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
    public List<Client> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        List<Client> firstClient = clients.subList(0, 10);  // Extract the first client
        for (Client client : firstClient) {
            System.out.println(client.toString());
        }
        return firstClient;
    }
}
