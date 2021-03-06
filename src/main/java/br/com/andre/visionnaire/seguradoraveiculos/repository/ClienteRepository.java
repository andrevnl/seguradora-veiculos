package br.com.andre.visionnaire.seguradoraveiculos.repository;

import br.com.andre.visionnaire.seguradoraveiculos.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>  {

    Cliente findClienteByCpf(String cpf);

    Page<Cliente> findClienteByCpf(String cpf, Pageable paginacao);

}
