package br.com.mambo.transporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mambo.transporte.model.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	public Veiculo findByPlaca(String placa);

}
