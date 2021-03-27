package br.com.andre.visionnaire.seguradoraveiculos.dto;

import br.com.andre.visionnaire.seguradoraveiculos.model.Cliente;
import br.com.andre.visionnaire.seguradoraveiculos.model.Uf;
import org.springframework.data.domain.Page;

public class ClienteDto {

    private String cpf;
    private String nome;
    private String cidade;
    private Uf uf;

    public ClienteDto(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.cidade = cliente.getCidade();
        this.uf = cliente.getUf();
    }

    public static Page<ClienteDto> fromDto(Page<Cliente> clientes) {
        return clientes.map(ClienteDto::new);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public Uf getUf() {
        return uf;
    }
}
