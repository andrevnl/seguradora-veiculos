package br.com.andre.visionnaire.seguradoraveiculos.controller;

import br.com.andre.visionnaire.seguradoraveiculos.dto.ClienteDto;
import br.com.andre.visionnaire.seguradoraveiculos.form.AtualizarClienteForm;
import br.com.andre.visionnaire.seguradoraveiculos.form.ClienteForm;
import br.com.andre.visionnaire.seguradoraveiculos.model.Cliente;
import br.com.andre.visionnaire.seguradoraveiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Page<ClienteDto> obterClientes(@RequestParam(required = false) String cpf,
                                          @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Cliente> clientes;

        if(cpf == null) {
            clientes = clienteRepository.findAll(paginacao);
        } else {
            clientes = clienteRepository.findClienteByCpf(cpf, paginacao);
        }

        return ClienteDto.fromDto(clientes);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm) {

        if(isClienteExiste(clienteForm.getCpf())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ja existe um cliente com esse CPF cadastrado.");
        }

        if(clienteForm.isCpfValido()) {
            Cliente novoCliente = new Cliente(clienteForm);
            clienteRepository.save(novoCliente);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente cadastrado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("CPF Inválido.");
        }

    }

    @PutMapping("/{cpf}")
    public ResponseEntity<?> atualizarCliente(@PathVariable String cpf,
                                                       @RequestBody @Valid AtualizarClienteForm clienteForm) {
        if(!isClienteExiste(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não encontrado");
        }

        Cliente cliente = Cliente.atualizar(cpf, clienteForm, clienteRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso.");
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> removerCliente(@PathVariable String cpf) {
        if(!isClienteExiste(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não encontrado");
        }
        clienteRepository.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso.");
    }

    private boolean isClienteExiste(String cpf) {
        return clienteRepository.existsById(cpf);
    }
}
