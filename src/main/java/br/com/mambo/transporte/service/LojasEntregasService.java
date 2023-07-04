package br.com.mambo.transporte.service;

import java.time.LocalDate;
import java.util.List;

import br.com.mambo.transporte.model.LojaEntregas;

public interface LojasEntregasService {

	public LojaEntregas addLojaEntregas(LojaEntregas lojaEntregas);
	
	public List<LojaEntregas> buscarTodasEntregas();
	
	public List<LojaEntregas> listarEntregasPorData(LocalDate data);
	
	public LojaEntregas buscarEntregasPorCodigo(String codigo);
	
}
