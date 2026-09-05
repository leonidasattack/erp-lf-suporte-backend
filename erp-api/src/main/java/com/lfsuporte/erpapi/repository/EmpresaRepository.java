package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
}