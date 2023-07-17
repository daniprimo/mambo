package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.LojaEntregas;

public interface LojaEntregasService {

	public LojaEntregas addNovaEntrega(LojaEntregas entrega);
	public List<LojaEntregas> buscarTodasEntregasCadastradas();
	public LojaEntregas buscarLojaPorNumeroDaEntrega(Long id);

	
}
