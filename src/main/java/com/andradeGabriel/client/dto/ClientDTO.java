package com.andradeGabriel.client.dto;


import com.andradeGabriel.client.entities.Client;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Field required")
    private String name;

    @NotBlank(message = "Field required")
    @Size(min = 11, max = 14)
    private String cpf;

    @Positive(message = "Income must be positive")
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public @NotBlank(message = "Field required") String getName() {
        return name;
    }

    public @NotBlank(message = "Field required") @Size(min = 11, max = 11) String getCpf() {
        return cpf;
    }

    public @Positive(message = "Income must be positive") Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}

