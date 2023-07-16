package br.com.mambo.transporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, String> {
	
	public Motorista findByNome(String nome);

	public List<Motorista> findAll();
	
}
