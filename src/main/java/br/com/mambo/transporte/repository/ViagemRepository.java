package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Viagem;

public interface ViagemRepository extends MongoRepository<Viagem, String> {

}
