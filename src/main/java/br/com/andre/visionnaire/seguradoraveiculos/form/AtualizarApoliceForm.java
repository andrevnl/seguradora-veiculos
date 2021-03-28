package br.com.andre.visionnaire.seguradoraveiculos.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AtualizarApoliceForm {

    private LocalDateTime inicioVigencia;
    private LocalDateTime fimVigencia;
    private String placaVeiculo;
    private BigDecimal valor;

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
