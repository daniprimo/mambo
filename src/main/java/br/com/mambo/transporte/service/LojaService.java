package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Loja;

public interface LojaService {
	
	public Loja addLoja(Loja loja);
	
	public List<Loja> listarTodasLojas();
	
	public Loja buscarLojaPeloNome(String nome);

}
