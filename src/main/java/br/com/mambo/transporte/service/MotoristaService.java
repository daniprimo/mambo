package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Motorista;

public interface MotoristaService {

	public List<Motorista> obterTodosMotoristas();
	public Motorista obterPorCodigo(String codigo);
	public Motorista obterPorNome(String nome);
	public Motorista criar(Motorista motorista);
	 
	
}
