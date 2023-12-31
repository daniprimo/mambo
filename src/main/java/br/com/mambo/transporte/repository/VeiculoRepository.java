package br.com.mambo.transporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
	
}
