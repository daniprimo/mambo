package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Ajudante;


public interface AjudanteRepository extends MongoRepository<Ajudante, String> {

	public Ajudante findByNome(String nome);
	
}
