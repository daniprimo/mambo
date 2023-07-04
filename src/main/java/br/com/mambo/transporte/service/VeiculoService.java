package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Veiculo;

public interface VeiculoService {
	
	public Veiculo addVeiculo(Veiculo veiculo);
	
	public List<Veiculo> listaDeTodosVeiculo();
	
	public Veiculo pesquisarPorPlaca(String placa);
	
}
