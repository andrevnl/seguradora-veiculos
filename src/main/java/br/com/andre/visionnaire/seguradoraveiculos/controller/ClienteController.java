package br.com.andre.visionnaire.seguradoraveiculos.controller;

import br.com.andre.visionnaire.seguradoraveiculos.form.ClienteForm;
import br.com.andre.visionnaire.seguradoraveiculos.model.Cliente;
import br.com.andre.visionnaire.seguradoraveiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public String cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente novoCliente = new Cliente(clienteForm);
        clienteRepository.save(novoCliente);
        return "Cliente cadastrado com sucesso";
    }
}
