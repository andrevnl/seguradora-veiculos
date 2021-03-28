package br.com.andre.visionnaire.seguradoraveiculos.model;

import br.com.andre.visionnaire.seguradoraveiculos.form.ApoliceForm;
import br.com.andre.visionnaire.seguradoraveiculos.form.AtualizarApoliceForm;
import br.com.andre.visionnaire.seguradoraveiculos.repository.ApoliceRepository;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Apolice {

    @Id
    private String numero;
    private LocalDateTime inicioVigencia;
    private LocalDateTime fimVigencia;
    private String placaVeiculo;
    private BigDecimal valor;

    public Apolice() {
    }

    public Apolice(ApoliceForm apoliceForm) {
        this.inicioVigencia = apoliceForm.getInicioVigencia();
        this.fimVigencia = apoliceForm.getFimVigencia();
        this.placaVeiculo = apoliceForm.getPlacaVeiculo();
        this.valor = apoliceForm.getValor();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDateTime inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDateTime getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDateTime fimVigencia) {
        this.fimVigencia = fimVigencia;
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
    public static Apolice atualizar(String numero, AtualizarApoliceForm apoliceForm, ApoliceRepository apoliceRepository) {
        Apolice apolice = apoliceRepository.findApoliceByNumero(numero);
        if (apoliceForm.getInicioVigencia() != null) { apolice.setInicioVigencia(apoliceForm.getInicioVigencia());  }
        if (apoliceForm.getFimVigencia()    != null) { apolice.setFimVigencia(apoliceForm.getFimVigencia());        }
        if (apoliceForm.getPlacaVeiculo()   != null) { apolice.setPlacaVeiculo(apoliceForm.getPlacaVeiculo());      }
        if (apoliceForm.getValor()          != null) { apolice.setValor(apoliceForm.getValor());                    }
        return apolice;
    }
}
