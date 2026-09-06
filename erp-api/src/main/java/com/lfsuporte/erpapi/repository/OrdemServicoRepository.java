package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.OrdemServico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdemServicoRepository extends MongoRepository<OrdemServico, String> {
}