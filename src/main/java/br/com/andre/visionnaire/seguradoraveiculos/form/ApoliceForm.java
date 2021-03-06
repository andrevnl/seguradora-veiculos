package br.com.andre.visionnaire.seguradoraveiculos.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApoliceForm {

    @NotNull(message = "{inicioVigencia.nulo}")
    private LocalDateTime inicioVigencia;
    @NotNull(message = "{fimVigencia.nulo}")
    private LocalDateTime fimVigencia;
    @NotNull(message = "{placaVeiculo.nulo}") @NotEmpty(message = "{placaVeiculo.vazio}")
    private String placaVeiculo;
    @NotNull(message = "{valor.nulo}")
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
