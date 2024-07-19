package com.andradeGabriel.client.services;

import com.andradeGabriel.client.dto.ClientDTO;
import com.andradeGabriel.client.entities.Client;
import com.andradeGabriel.client.repositories.ClientRepository;
import com.andradeGabriel.client.services.exceptions.DatabaseException;
import com.andradeGabriel.client.services.exceptions.UserNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO getClient(Long id) {
        try {

        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
        } catch (NoSuchElementException e) {
            throw new UserNotFound("Client with id " + id + " not found");
        }
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> getAllClients(Pageable pageable) { // get all clients in pages
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }
//
//    @Transactional(readOnly = true)
//    public List<ClientDTO> getAllClients() { // get all clients in a json array
//        List<Client> clients = clientRepository.findAll();
//        return clients.stream().map(x -> new ClientDTO(x)).toList();
//    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();

        copyDtoToEntity(clientDTO, client);

        client = clientRepository.save(client);

        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        try {

        Client client = clientRepository.getReferenceById(id);
        copyDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new UserNotFound("Client with id " + id + " not found");
        }

    }

    @Transactional
    public ResponseEntity<Void> deleteClient(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new UserNotFound("Client with id " + id + " not found");
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }


}
