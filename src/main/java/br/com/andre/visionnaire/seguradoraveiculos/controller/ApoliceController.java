package br.com.andre.visionnaire.seguradoraveiculos.controller;

import br.com.andre.visionnaire.seguradoraveiculos.repository.ApoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {

    @Autowired
    private ApoliceRepository apoliceRepository;

    @GetMapping()
    public void listaApolices() {
        System.out.println("listaApolices");
    }

    @GetMapping("/{id}")
    public void consultarApolice(@PathVariable Long id) {
        System.out.println("consultarApolice + " + id);
    }

    @PostMapping
    public void cadastrarApolice() {
        System.out.println("cadastrarApolice");
    }

}
