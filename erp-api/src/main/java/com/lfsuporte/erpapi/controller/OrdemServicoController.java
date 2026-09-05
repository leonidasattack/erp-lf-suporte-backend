package com.lfsuporte.erpapi.controller;

import com.lfsuporte.erpapi.model.OrdemServico;
import com.lfsuporte.erpapi.repository.OrdemServicoRepository;
import com.lfsuporte.erpapi.repository.ClienteRepository; // NOVO: Importamos o repositório de clientes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // NOVO: Injetamos o repositório de clientes para podermos fazer buscas na
    // tabela deles
    @Autowired
    private ClienteRepository clienteRepository;

    // ROTA GET: Lista todos os chamados
    @GetMapping
    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    // ROTA GET por ID: Busca um chamado específico
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable UUID id) {
        return ordemServicoRepository.findById(id)
                .map(ordem -> ResponseEntity.ok(ordem))
                .orElse(ResponseEntity.notFound().build());
    }

    // ROTA POST: Abre uma nova Ordem de Serviço (AGORA BLINDADA!)
    @PostMapping
    public ResponseEntity<OrdemServico> adicionar(@RequestBody OrdemServico ordemServico) {
        // 1. Verifica se mandaram um cliente e se ele tem ID preenchido
        if (ordemServico.getCliente() == null || ordemServico.getCliente().getId() == null) {
            return ResponseEntity.badRequest().build(); // Retorna Status 400 se faltar o cliente
        }

        // 2. Busca o cliente de verdade no banco de dados usando o ID
        return clienteRepository.findById(ordemServico.getCliente().getId())
                .map(clienteEncontrado -> {
                    // 3. Amarra o cliente oficial e completo na Ordem de Serviço
                    ordemServico.setCliente(clienteEncontrado);

                    // 4. Salva a Ordem de Serviço no banco
                    OrdemServico salva = ordemServicoRepository.save(ordemServico);
                    return ResponseEntity.ok(salva); // Retorna Status 200 com os dados
                })
                .orElse(ResponseEntity.badRequest().build()); // Retorna Status 400 se o ID não existir no banco
    }

    // ROTA PUT: Atualiza os dados de um chamado existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable UUID id, @RequestBody OrdemServico ordemAtualizada) {
        return ordemServicoRepository.findById(id)
                .map(ordemExistente -> {
                    ordemExistente.setEquipamento(ordemAtualizada.getEquipamento());
                    ordemExistente.setDefeitoRelatado(ordemAtualizada.getDefeitoRelatado());
                    ordemExistente.setStatus(ordemAtualizada.getStatus());

                    OrdemServico salva = ordemServicoRepository.save(ordemExistente);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ROTA DELETE: Remove um chamado pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        if (ordemServicoRepository.existsById(id)) {
            ordemServicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}