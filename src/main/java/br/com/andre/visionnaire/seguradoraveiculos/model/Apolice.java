package br.com.andre.visionnaire.seguradoraveiculos.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Apolice {

    @Id
    private Long numApolice;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String placaVeiculo;
    private BigDecimal valor;

    public Long getNumApolice() {
        return numApolice;
    }

    public void setNumApolice(Long numApolice) {
        this.numApolice = numApolice;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
