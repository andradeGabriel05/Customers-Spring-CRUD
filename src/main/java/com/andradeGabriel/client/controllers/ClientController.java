package com.andradeGabriel.client.controllers;

import com.andradeGabriel.client.dto.ClientDTO;
import com.andradeGabriel.client.entities.Client;
import com.andradeGabriel.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable final Long id) {
        ClientDTO clientDTO = clientService.getClient(id);
        return ResponseEntity.ok(clientDTO);
    }

}
