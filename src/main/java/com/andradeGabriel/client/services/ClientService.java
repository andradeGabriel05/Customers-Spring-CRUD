package com.andradeGabriel.client.services;

import com.andradeGabriel.client.dto.ClientDTO;
import com.andradeGabriel.client.entities.Client;
import com.andradeGabriel.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }


}
