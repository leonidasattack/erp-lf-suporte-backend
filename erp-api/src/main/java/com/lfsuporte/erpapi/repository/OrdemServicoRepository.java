package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, UUID> {
}