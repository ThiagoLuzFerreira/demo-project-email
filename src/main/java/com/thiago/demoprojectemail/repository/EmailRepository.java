package com.thiago.demoprojectemail.repository;

import com.thiago.demoprojectemail.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmailRepository extends MongoRepository<Email, UUID> {
}
