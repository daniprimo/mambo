package br.com.mambo.transporte.persistencia.service;

import java.util.List;

import br.com.mambo.transporte.model.LojaEntregas;

public interface LojaEntregasService {

	public LojaEntregas addNovaEntrega(LojaEntregas entrega);
	public List<LojaEntregas> buscarTodasEntregasCadastradas();
	public LojaEntregas buscarLojaPorNumeroDaEntrega(Long id);
	public List<LojaEntregas> salvoUmaListaDeEntregas(List<LojaEntregas> entregas);

	
}
