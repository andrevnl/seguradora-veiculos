package br.com.andre.visionnaire.seguradoraveiculos.model;

import br.com.andre.visionnaire.seguradoraveiculos.form.ClienteForm;
import org.springframework.data.annotation.Id;

public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String cidade;
    private Uf uf;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String cidade, Uf uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Cliente(ClienteForm clienteForm) {
        this.cpf = clienteForm.getCpf();
        this.nome = clienteForm.getNome();
        this.cidade = clienteForm.getCidade();
        this.uf = Uf.valueOf(clienteForm.getUf());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
}
