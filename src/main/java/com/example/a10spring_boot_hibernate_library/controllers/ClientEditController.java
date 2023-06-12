package com.example.a10spring_boot_hibernate_library.controllers;

import com.example.a10spring_boot_hibernate_library.entities.Client;
import com.example.a10spring_boot_hibernate_library.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientEditController {

    private final ClientService clientService;

    @Autowired
    public ClientEditController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/editclient/{id}")
    public String getEditClientForm(@PathVariable("id") Integer id, Model model) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));

        model.addAttribute("client", client);
        return "edit-client";
    }

    @PostMapping("/updateclient")
    public String updateClient(Client client) {
        clientService.updateClient(client);
        return "redirect:/singleclient/" + client.getClientId();
    }
}
