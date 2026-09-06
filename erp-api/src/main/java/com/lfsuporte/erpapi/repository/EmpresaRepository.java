package com.lfsuporte.erpapi.repository;

import com.lfsuporte.erpapi.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
}