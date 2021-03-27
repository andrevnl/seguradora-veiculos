package br.com.andre.visionnaire.seguradoraveiculos.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String cidade;
    @NotNull @NotEmpty @Length(min = 2, max = 2)
    private String uf;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }
}
