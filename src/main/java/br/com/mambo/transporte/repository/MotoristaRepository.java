package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Motorista;

public interface MotoristaRepository extends MongoRepository<Motorista, String> {
	
	public Motorista findByNome(String nome);
	
}
