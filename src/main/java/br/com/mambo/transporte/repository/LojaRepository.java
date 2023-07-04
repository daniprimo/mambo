package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Loja;


public interface LojaRepository extends MongoRepository<Loja, String> {
	
	public Loja findByNomeLoja(String nomeLoja);
	
}
