package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Origem;


public interface OrigemRepository extends MongoRepository<Origem, String> {

	public Origem findByNome(String nome);
	
}
