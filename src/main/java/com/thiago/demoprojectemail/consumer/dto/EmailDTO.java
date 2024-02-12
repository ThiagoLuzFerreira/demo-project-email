package com.thiago.demoprojectemail.consumer.dto;

import java.util.UUID;

public record EmailDTO(UUID id,
                       String email,
                       String firstName,
                       String lastName,
                       String cep,
                       String subject,
                       String text) {
}
