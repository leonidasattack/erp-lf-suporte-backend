package com.lfsuporte.erpapi.controller;

import com.lfsuporte.erpapi.model.Empresa;
import com.lfsuporte.erpapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    // ROTA GET: Busca todas as empresas cadastradas no banco
    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    // ROTA GET por ID: Busca uma empresa específica pelo seu ID (UUID)
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable UUID id) {
        return empresaRepository.findById(id)
                .map(empresa -> ResponseEntity.ok(empresa))
                .orElse(ResponseEntity.notFound().build());
    }

    // ROTA PUT: Atualiza os dados de uma empresa existente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable UUID id, @RequestBody Empresa empresaAtualizada) {
        return empresaRepository.findById(id)
                .map(empresaExistente -> {
                    empresaExistente.setRazaoSocial(empresaAtualizada.getRazaoSocial());
                    empresaExistente.setNomeFantasia(empresaAtualizada.getNomeFantasia());
                    empresaExistente.setCpfCnpj(empresaAtualizada.getCpfCnpj());
                    empresaExistente.setCnpj(empresaAtualizada.getCnpj());
                    empresaExistente.setCep(empresaAtualizada.getCep());
                    empresaExistente.setLogradouro(empresaAtualizada.getLogradouro());
                    empresaExistente.setNumero(empresaAtualizada.getNumero());
                    empresaExistente.setBairro(empresaAtualizada.getBairro());
                    empresaExistente.setCidade(empresaAtualizada.getCidade());
                    empresaExistente.setEstado(empresaAtualizada.getEstado());

                    Empresa salva = empresaRepository.save(empresaExistente);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ROTA POST: Recebe os dados e salva uma nova empresa no banco
    @PostMapping
    public Empresa adicionar(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // ROTA DELETE: Remove uma empresa do banco de dados pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna Status 204 (Sucesso, sem conteúdo)
        }
        return ResponseEntity.notFound().build(); // Retorna Status 404 se o ID não existir
    }
}