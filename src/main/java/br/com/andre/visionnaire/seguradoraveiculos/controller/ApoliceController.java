package br.com.andre.visionnaire.seguradoraveiculos.controller;

import br.com.andre.visionnaire.seguradoraveiculos.dto.ApoliceDto;
import br.com.andre.visionnaire.seguradoraveiculos.form.ApoliceForm;
import br.com.andre.visionnaire.seguradoraveiculos.form.AtualizarApoliceForm;
import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import br.com.andre.visionnaire.seguradoraveiculos.repository.ApoliceRepository;
import br.com.andre.visionnaire.seguradoraveiculos.utils.NumeroAleatorio;
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
@RequestMapping("/apolice")
public class ApoliceController {

    @Autowired
    private ApoliceRepository apoliceRepository;

    @GetMapping()
    public Page<ApoliceDto> obterApolices(@RequestParam(required = false) String numero,
                                          @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Apolice> apolices;

        if(numero == null) {
            apolices = apoliceRepository.findAll(paginacao);
        } else {
            apolices = apoliceRepository.findApoliceByNumero(numero, paginacao);
        }

        return ApoliceDto.fromDto(apolices);
    }

    @PostMapping
    public ResponseEntity<ApoliceDto> cadastrarApolice(@RequestBody @Valid ApoliceForm apoliceForm) {
        Apolice novaApolice = new Apolice(apoliceForm);
        novaApolice.setNumero(NumeroAleatorio.gerarNumeroAleatorioValidoParaApolice(apoliceRepository));
        apoliceRepository.save(novaApolice);
        return ResponseEntity.ok(new ApoliceDto(novaApolice));
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> atualizarApolice(@PathVariable String numero,
                                              @RequestBody @Valid AtualizarApoliceForm apoliceForm) {
        if(!isApoliceExiste(numero)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Número da apólice não encontrado");
        }
        Apolice apolice = Apolice.atualizar(numero, apoliceForm, apoliceRepository);
        apoliceRepository.save(apolice);
        return ResponseEntity.ok(new ApoliceDto(apolice));
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<?> removerApolice(@PathVariable String numero) {
        if(!isApoliceExiste(numero)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Número da apólice não encontrado");
        }
        apoliceRepository.deleteById(numero);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso.");
    }

    private boolean isApoliceExiste(String numero) {
        return apoliceRepository.existsById(numero);
    }
}
