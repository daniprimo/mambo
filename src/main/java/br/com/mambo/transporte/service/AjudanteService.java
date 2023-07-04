package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Ajudante;

public interface AjudanteService {
	
	public Ajudante addAjudante(Ajudante ajudante);
	
	public List<Ajudante> buscarTodosOsAjudantes();
	
	public Ajudante pesquisarAjudantePorNome(String nome);

}
