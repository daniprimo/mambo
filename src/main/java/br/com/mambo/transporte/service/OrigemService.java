package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Origem;

public interface OrigemService {

	public Origem addOrigem (Origem origem);
	public List<Origem> listaDeOrigens();
	public Origem pesquisarOrigemPelaNome(String nome);
	
}
