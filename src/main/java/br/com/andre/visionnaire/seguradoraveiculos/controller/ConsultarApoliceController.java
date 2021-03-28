package br.com.andre.visionnaire.seguradoraveiculos.controller;

import br.com.andre.visionnaire.seguradoraveiculos.dto.ConsultarApoliceDto;
import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import br.com.andre.visionnaire.seguradoraveiculos.repository.ApoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultar")
public class ConsultarApoliceController {

    @Autowired
    ApoliceRepository apoliceRepository;

    @GetMapping("/{numero}")
    public ResponseEntity<ConsultarApoliceDto> consultarApolice(@PathVariable String numero) {
        Apolice apolice = apoliceRepository.findApoliceByNumero(numero);

        if(apolice != null) {
            return ResponseEntity.ok(new ConsultarApoliceDto(apolice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
