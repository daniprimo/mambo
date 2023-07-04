package br.com.mambo.transporte.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.LojaEntregas;
import java.time.LocalDate;



public interface LojasEntregasRepository extends MongoRepository<LojaEntregas, String> {

	List<LojaEntregas> findByData(LocalDate data);

	
	
}
