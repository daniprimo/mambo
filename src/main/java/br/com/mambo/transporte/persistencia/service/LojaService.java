package br.com.mambo.transporte.persistencia.service;

import java.util.List;

import br.com.mambo.transporte.model.Loja;

public interface LojaService {
	
	public Loja addNovaLoja(Loja loja);
	public List<Loja> buscarTodasLojasCadastradas();
	public Loja buscarLojaPorNome(String nome);

}
