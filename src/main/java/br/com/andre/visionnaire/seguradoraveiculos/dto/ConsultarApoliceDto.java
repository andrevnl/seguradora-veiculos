package br.com.andre.visionnaire.seguradoraveiculos.dto;

import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

public class ConsultarApoliceDto {

    private boolean vencida;
    private String diasAteVencimento;
    private String placaVeiculo;
    private BigDecimal valor;

    public ConsultarApoliceDto() {

    }

    public ConsultarApoliceDto(Apolice apolice) {
        this.vencida = isApoliceVencida(apolice);
        this.diasAteVencimento = diasAteVencimentoApolice(apolice);
        this.placaVeiculo = apolice.getPlacaVeiculo();
        this.valor = apolice.getValor();
    }

    private String diasAteVencimentoApolice(Apolice apolice) {
        LocalDate hoje = LocalDate.now();
        LocalDate fimVigencia = apolice.getFimVigencia().toLocalDate();
        Integer dias = Period.between(hoje, fimVigencia).getDays();
        if(dias > 0)
            return "Vence em " + dias + " dia(s)";
        else
            return "Venceu há " + Math.abs(dias) + " dia(s)";
    }

    private boolean isApoliceVencida(Apolice apolice) {
        LocalDateTime hoje = LocalDateTime.now();
        return hoje.isAfter(apolice.getFimVigencia());
    }

    public boolean isVencida() {
        return vencida;
    }

    public String getDiasAteVencimento() {
        return diasAteVencimento;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
