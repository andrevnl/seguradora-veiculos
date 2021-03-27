package br.com.andre.visionnaire.seguradoraveiculos.repository;

import br.com.andre.visionnaire.seguradoraveiculos.model.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApoliceRepository extends MongoRepository<Apolice, Long> {

}
