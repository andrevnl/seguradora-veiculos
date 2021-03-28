package br.com.andre.visionnaire.seguradoraveiculos.dto;

import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApoliceDto {

    private String numero;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String placaVeiculo;
    private BigDecimal valor;

    public ApoliceDto(Apolice apolice) {
        this.numero = apolice.getNumero();
        this.dataInicio = apolice.getDataInicio();
        this.dataFim = apolice.getDataFim();
        this.placaVeiculo = apolice.getPlacaVeiculo();
        this.valor = apolice.getValor();
    }

    public static Page<ApoliceDto> fromDto(Page<Apolice> apolices) {
        return apolices.map(ApoliceDto::new);
    }

    public String getNumero() {
        return numero;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
