package br.com.andre.visionnaire.seguradoraveiculos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Documentação da API: \n\r http://localhost:8080/swagger-ui.html#/");
    }
}
