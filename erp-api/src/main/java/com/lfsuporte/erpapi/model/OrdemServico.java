package com.lfsuporte.erpapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "ordens_servico")
public class OrdemServico {

    @Id
    private String id;

    // --- LIGAÇÃO COM O CLIENTE ---
    @DBRef
    private Cliente cliente;
    // ----------------------------------

    private String equipamento;
    private String defeitoRelatado;
    private String status;
    private LocalDateTime dataAbertura;

    // NOVOS CAMPOS ADICIONADOS
    private Double valor;
    private String solucaoTecnica;
    private String dataCriacao;

    public OrdemServico() {
        this.dataAbertura = LocalDateTime.now();
        this.status = "ABERTO";
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeitoRelatado() {
        return defeitoRelatado;
    }

    public void setDefeitoRelatado(String defeitoRelatado) {
        this.defeitoRelatado = defeitoRelatado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getSolucaoTecnica() {
        return solucaoTecnica;
    }

    public void setSolucaoTecnica(String solucaoTecnica) {
        this.solucaoTecnica = solucaoTecnica;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}