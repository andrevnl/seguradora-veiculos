package br.com.andre.visionnaire.seguradoraveiculos.form;

import br.com.andre.visionnaire.seguradoraveiculos.model.Uf;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteForm {

    @NotNull(message = "{cpf.nulo}") @NotEmpty(message = "{cpf.vazio}")
    private String cpf;
    @NotNull(message = "{nome.nulo}") @NotEmpty(message = "{nome.vazio}")
    private String nome;
    @NotNull(message = "{cidade.nulo}") @NotEmpty(message = "{cidade.vazio}")
    private String cidade;
    @NotNull(message = "{uf.nulo}")
    private Uf uf;

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

    public boolean isCpfValido(){
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if(erros.size() > 0) { return false; } else { return true; }
    }
}
