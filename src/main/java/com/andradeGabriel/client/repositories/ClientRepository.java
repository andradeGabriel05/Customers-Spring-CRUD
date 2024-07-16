package com.andradeGabriel.client.repositories;

import com.andradeGabriel.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
