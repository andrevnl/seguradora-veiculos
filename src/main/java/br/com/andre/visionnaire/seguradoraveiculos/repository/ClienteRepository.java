package br.com.andre.visionnaire.seguradoraveiculos.repository;

import br.com.andre.visionnaire.seguradoraveiculos.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, Long>  {

}
