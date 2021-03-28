package br.com.andre.visionnaire.seguradoraveiculos.model;

import br.com.andre.visionnaire.seguradoraveiculos.form.ApoliceForm;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Apolice {

    @Id
    private String numero;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String placaVeiculo;
    private BigDecimal valor;

    public Apolice() {
    }

    public Apolice(ApoliceForm apoliceForm) {
        this.dataInicio = apoliceForm.getDataInicio();
        this.dataFim = apoliceForm.getDataFim();
        this.placaVeiculo = apoliceForm.getPlacaVeiculo();
        this.valor = apoliceForm.getValor();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
