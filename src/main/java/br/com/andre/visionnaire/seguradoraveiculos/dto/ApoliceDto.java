package br.com.andre.visionnaire.seguradoraveiculos.dto;

import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApoliceDto {

    private String numero;
    private LocalDateTime inicioVigencia;
    private LocalDateTime fimVigencia;
    private String placaVeiculo;
    private BigDecimal valor;

    public ApoliceDto(Apolice apolice) {
        this.numero = apolice.getNumero();
        this.inicioVigencia = apolice.getInicioVigencia();
        this.fimVigencia = apolice.getFimVigencia();
        this.placaVeiculo = apolice.getPlacaVeiculo();
        this.valor = apolice.getValor();
    }

    public static Page<ApoliceDto> fromDto(Page<Apolice> apolices) {
        return apolices.map(ApoliceDto::new);
    }

    public String getNumero() {
        return numero;
    }

    public LocalDateTime getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDateTime getFimVigencia() {
        return fimVigencia;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
