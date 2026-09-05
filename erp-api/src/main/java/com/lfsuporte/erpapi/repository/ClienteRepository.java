package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}