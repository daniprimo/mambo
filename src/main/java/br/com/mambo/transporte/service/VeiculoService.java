package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Veiculo;

public interface VeiculoService {
	
	public List<Veiculo> todosOsVeiculos();
	public Veiculo obterPorPlaca(String placa);
	public Veiculo criar(Veiculo veiculo);
	public List<Veiculo> obterTodosVeiculosApartirDaQuantidadeDePallets(Integer quantidade);

	
}
