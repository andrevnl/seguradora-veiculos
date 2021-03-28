package br.com.andre.visionnaire.seguradoraveiculos.repository;

import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApoliceRepository extends MongoRepository<Apolice, String> {

    Page<Apolice> findApoliceByNumero(String numero, Pageable paginacao);

}
