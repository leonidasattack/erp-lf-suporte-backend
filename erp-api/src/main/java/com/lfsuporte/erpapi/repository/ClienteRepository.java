package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}