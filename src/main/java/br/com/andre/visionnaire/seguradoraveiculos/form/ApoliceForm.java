package br.com.andre.visionnaire.seguradoraveiculos.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApoliceForm {

    @NotNull(message = "{dataInicio.nulo}")
    private LocalDateTime dataInicio;
    @NotNull(message = "{dataFim.nulo}")
    private LocalDateTime dataFim;
    @NotNull(message = "{placaVeiculo.nulo}") @NotEmpty(message = "{placaVeiculo.vazio}")
    private String placaVeiculo;
    @NotNull(message = "{valor.nulo}")
    private BigDecimal valor;

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
