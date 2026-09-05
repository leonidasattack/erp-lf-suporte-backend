package com.lfsuporte.erpapi.controller;

import com.lfsuporte.erpapi.model.OrdemServico;
import com.lfsuporte.erpapi.repository.OrdemServicoRepository;
import com.lfsuporte.erpapi.repository.ClienteRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable UUID id) {
        return ordemServicoRepository.findById(id)
                .map(ordem -> ResponseEntity.ok(ordem))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdemServico> adicionar(@RequestBody OrdemServico ordemServico) {
        if (ordemServico.getCliente() == null || ordemServico.getCliente().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        return clienteRepository.findById(ordemServico.getCliente().getId())
                .map(clienteEncontrado -> {
                    ordemServico.setCliente(clienteEncontrado);
                    OrdemServico salva = ordemServicoRepository.save(ordemServico);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable UUID id, @RequestBody OrdemServico ordemAtualizada) {
        return ordemServicoRepository.findById(id)
                .map(ordemExistente -> {
                    ordemExistente.setEquipamento(ordemAtualizada.getEquipamento());
                    ordemExistente.setDefeitoRelatado(ordemAtualizada.getDefeitoRelatado());
                    ordemExistente.setStatus(ordemAtualizada.getStatus());

                    // NOVOS CAMPOS ADICIONADOS AQUI:
                    ordemExistente.setValor(ordemAtualizada.getValor());
                    ordemExistente.setSolucaoTecnica(ordemAtualizada.getSolucaoTecnica());
                    if (ordemAtualizada.getDataCriacao() != null) {
                        ordemExistente.setDataCriacao(ordemAtualizada.getDataCriacao());
                    }

                    OrdemServico salva = ordemServicoRepository.save(ordemExistente);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        if (ordemServicoRepository.existsById(id)) {
            ordemServicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}